package com.printmaster.nk.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.printmaster.nk.model.Role;
import com.printmaster.nk.model.User;
 
/**
 * A custom authentication manager that allows access if the user details
 * exist in the database and if the username and password are not the same.
 * Otherwise, throw a {@link BadCredentialsException}
 */
public class CustomAuthenticationManager/* implements AuthenticationManager*/ {
 /*
 protected static Logger logger = Logger.getLogger("service");
 
 // Our custom DAO layer
 @Autowired
 private UserService userService;
 
 // We need an BCryptPasswordEncoder encoder since our passwords in the database are BCryptPasswordEncoder encoded. 
 @Autowired
 private BCryptPasswordEncoder passwordEncoder;
  
 public Authentication authenticate(Authentication auth)
   throws AuthenticationException {
 
  logger.debug("Performing custom authentication");
   
  // Init a database user object
  User user = null;
   
  try {
   // Retrieve user details from database
   user = userService.findByUserName(auth.getName());
  } catch (Exception e) {
   logger.error("User does not exists!");
   throw new BadCredentialsException("User does not exists!");
  }
   
  // Compare passwords
  // Make sure to encode the password first before comparing
  if (  passwordEncoder.matches((CharSequence) auth.getCredentials(), user.getPassword()) == false ) {
   logger.error("Wrong password!");
   throw new BadCredentialsException("Wrong password!");
  }
   
  // Here's the main logic of this custom authentication manager
  // Username and password must be the same to authenticate
  if (auth.getName().equals(auth.getCredentials()) == true) {
   logger.debug("Entered username and password are the same!");
   throw new BadCredentialsException("Entered username and password are the same!");
    
  } else {
    
   logger.debug("User details are good and ready to go");
   return new UsernamePasswordAuthenticationToken(
     auth.getName(), 
     auth.getCredentials(), 
     buildUserAuthority(user.getRole()));
  }
 }
  
 private List<GrantedAuthority> buildUserAuthority(Role userRole) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		setAuths.add(new SimpleGrantedAuthority(userRole.getName()));

		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);

		return result;
	}
 */
}
