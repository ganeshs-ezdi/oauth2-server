package com.ezdi.security;

import com.ezdi.beans.User;
import com.ezdi.daos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by EZDI\ganesh.s on 25/7/16.
 */
public class UserJpaService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findOne(s);
        if( user == null ) {
            throw new UsernameNotFoundException("Unable to find username : " + s);
        }
        return new PrincipalDetails(user);
    }
}
