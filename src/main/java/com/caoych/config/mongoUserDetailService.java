package com.caoych.config;

import com.caoych.db.People;
import com.caoych.db.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by caoych on 2016/12/11.
 */
@Component
public class mongoUserDetailService implements UserDetailsService {
    @Autowired
    private PeopleRepository pRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        People p = pRepo.findByFirstName(username);
        if ( p == null ) {
            throw new UsernameNotFoundException(username);
        } else {
            Set<GrantedAuthority> auth = new HashSet<GrantedAuthority>();
            auth.add(new SimpleGrantedAuthority("ROLE_USER"));
            return new User(p.getFirstName(),p.getPasswd(),auth);
        }
    }
}
