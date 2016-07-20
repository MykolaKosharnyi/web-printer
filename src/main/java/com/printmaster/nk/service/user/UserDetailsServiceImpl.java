package com.printmaster.nk.service.user;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.model.User;
import com.printmaster.nk.service.UserService;

public class UserDetailsServiceImpl implements UserDetailsService{
    
	@Autowired
    private UserService userService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)  {
       // User user = userService.findByUsername(username);
    	User user = userService.getUserById(1);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        //for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
       // }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}