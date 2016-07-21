package com.printmaster.nk.service.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.model.Role;
import com.printmaster.nk.model.User;
import com.printmaster.nk.service.UserService;

@Transactional(readOnly=true)
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{
    
	@Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        
        if(user==null) {throw new UsernameNotFoundException("No such user: " + username);}
        
   /*     boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;*/

        return new org.springframework.security.core.userdetails.User(
        		user.getUsername(),
        		user.getPassword(),
        		true, 
                true, 
                true, 
                true, 
                getAuthorities(user.getRole()));
    }
    
    public List<String> getRolesAsList(Role role) {
        List <String> rolesAsList = new ArrayList<String>();
        rolesAsList.add(role.getName());
        return rolesAsList;
    }

    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

    public Collection<? extends GrantedAuthority> getAuthorities(Role role) {
        List<GrantedAuthority> authList = getGrantedAuthorities(getRolesAsList(role));
        return authList;
    }
}