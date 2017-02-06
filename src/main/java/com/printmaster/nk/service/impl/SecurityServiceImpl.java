package com.printmaster.nk.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.printmaster.nk.service.SecurityService;
import com.printmaster.nk.service.UserService;

/**
 * We create SecurityService to provide auto login user after resgistering an account. 
 * */
@Service("securityService")
public class SecurityServiceImpl implements SecurityService {

    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

	// Our custom DAO layer
	 @Autowired
	 private UserService userService;
	 
	 // We need an BCryptPasswordEncoder encoder since our passwords in the database are BCryptPasswordEncoder encoded. 
	 @Autowired
	 private BCryptPasswordEncoder passwordEncoder;
	
    @Override
    public String findLoggedInUsername(){
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails)userDetails).getUsername();
        }
        return null;
    }

    @Override
    public void autologin(String username, String password) {   
    
    	// Init a database user object
    	com.printmaster.nk.model.entity.User user =  userService.findByUserName(username);

    	  // Compare passwords
    	  // Make sure to encode the password first before comparing
    	  if (  passwordEncoder.matches(password, user.getPassword()) ) {
    		  logger.debug("User details are good and ready to go");
    		  Authentication auth = 
            		  new UsernamePasswordAuthenticationToken(user.getUsername(), password, buildUserAuthority(user.getRole()));

            		SecurityContextHolder.getContext().setAuthentication(auth);
    		  
    		  
       	  	/*  SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user.getUsername(),
          			password, buildUserAuthority(user.getRole())));*/
       	  	  
    	  } else {
    		  logger.error("Wrong password!");
    		  throw new BadCredentialsException("Wrong password!");
    	  }	  
    }
    
    private List<GrantedAuthority> buildUserAuthority(String userRole) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		setAuths.add(new SimpleGrantedAuthority(userRole));

		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);

		return result;
	}
}
