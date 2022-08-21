package com.mykoshar.shop.api.model.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mykoshar.shop.api.model.entity.User;
import org.springframework.security.authentication.AuthenticationProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * A custom authentication manager that allows access if the user details
 * exist in the database and if the username and password are not the same.
 * Otherwise, throw a {@link BadCredentialsException}
 */

@Slf4j
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider  {
	 /**
	  * Our custom DAO layer
	  */
	 private UserService userService;
	
	/**
	  * We need an BCryptPasswordEncoder encoder since our passwords in the database are BCryptPasswordEncoder encoded. 
	  */
	 private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	
		  log.debug("Performing custom authentication");
		  
		   // Retrieve user details from database
		  User user = userService.findByEmail(authentication.getName());
		  
		  if( user == null ){
			  log.error("User does not exists!");
			  throw new BadCredentialsException("User does not exists!");
		  }
			    
		  // Compare passwords
		  // Make sure to encode the password first before comparing
		  if (  passwordEncoder.matches((CharSequence) authentication.getCredentials(), user.getPassword()) == false ) {
		   log.error("Wrong password!");
		   throw new BadCredentialsException("Wrong password!");
		  }
	
		  // Here's the main logic of this custom authentication manager
		  // Username and password must be the same to authenticate
		  if (authentication.getName().equals(authentication.getCredentials()) == true) {
		   log.debug("Entered username and password are the same!");
		   throw new BadCredentialsException("Entered username and password are the same!");
		    
		  } else {
		    
		   log.debug("User details are good and ready to go");
		   return new UsernamePasswordAuthenticationToken(
				   authentication.getName(), 
				   authentication.getCredentials(), 
		     buildUserAuthority(user.getRole()));
		  }
	}
	
	private List<GrantedAuthority> buildUserAuthority(String userRole) {
	
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
	
		// Build user's authorities
		setAuths.add(new SimpleGrantedAuthority(userRole));
	
		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);
	
		return result;
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}
	
	public UserService getUserService() {
		return userService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public BCryptPasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}
	
	public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
 
}