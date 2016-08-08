package com.printmaster.nk.service.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.printmaster.nk.model.Role;
import com.printmaster.nk.service.UserService;

/*
 * We create SecurityService to provide current loggedin user and auto login user after resgistering an account. 
 * */

@Service("securityService")
public class SecurityServiceImpl implements SecurityService {
   
//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private UserDetailsService customUserDetailsService;
    
 //   @Autowired
//    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

	
	// Our custom DAO layer
	 @Autowired
	 private UserService userService;
	 
	 // We need an BCryptPasswordEncoder encoder since our passwords in the database are BCryptPasswordEncoder encoded. 
	 @Autowired
	 private BCryptPasswordEncoder passwordEncoder;
	
    @Override
    public String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails)userDetails).getUsername();
        }
        return null;
    }

    @Override
    public void autologin(String username, String password) {   
    	
//    	com.printmaster.nk.model.User user = userService.getUserById(2);

//    	List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();
//    	AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
//    	/*AUTHORITIES.add(new SimpleGrantedAuthority("ADMIN"));*/
//    	SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(username,
//    			password, AUTHORITIES));
    	
  ////////////////////////////////////////  	
    	
    	// Init a database user object
    	com.printmaster.nk.model.User user =  userService.findByUserName(username);

    	  // Compare passwords
    	  // Make sure to encode the password first before comparing
    	  if (  passwordEncoder.matches(password, user.getPassword()) ) {
    		  logger.debug("User details are good and ready to go");
       	  	  SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user.getUsername(),
          			password, buildUserAuthority(user.getRole())));
    	  } else {
    		  logger.error("Wrong password!");
    		  SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user.getUsername() + " - wrong",
            			password, buildUserAuthority(user.getRole())));
    	  }
    	 
	
    	
 ///////////////////////////////////////   	
    	
    	
    	
//    	UserDetails userDetails = new User(user.getUsername(), user.getPassword(), true, true, true, true, AUTHORITIES);
    	
//        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
//        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,
//        		password, userDetails.getAuthorities());
//
//        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
//
//        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
//            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//            logger.debug(String.format("Auto login %s successfully!", username));
//        }
    	  
    	  
    	  
    }
    
    private List<GrantedAuthority> buildUserAuthority(String userRole) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		setAuths.add(new SimpleGrantedAuthority(userRole));

		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);

		return result;
	}
}
