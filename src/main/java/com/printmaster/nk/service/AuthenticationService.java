package com.printmaster.nk.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.model.Role;

public class AuthenticationService implements UserDetailsService{
    
    private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Transactional(readOnly=true)
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
    	
    		com.printmaster.nk.model.User user = userService.findByUserName(username);
    		List<GrantedAuthority> authorities = buildUserAuthority(user.getRole());

    		return buildUserForAuthentication(user, authorities);
    		
    	}

    	// Converts com.mkyong.users.model.User user to
    	// org.springframework.security.core.userdetails.User
    	private User buildUserForAuthentication(com.printmaster.nk.model.User user, List<GrantedAuthority> authorities) {
    		return new User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
    	}

    	private List<GrantedAuthority> buildUserAuthority(Role userRole) {

    		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

    		// Build user's authorities
    		setAuths.add(new SimpleGrantedAuthority(userRole.getName()));

    		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

    		return Result;
    	}
}