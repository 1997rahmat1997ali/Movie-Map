package com.ali.Movie_Map.service;

import com.ali.Movie_Map.model.User;
import com.ali.Movie_Map.model.UserPrinciple;
import com.ali.Movie_Map.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if(user==null){
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("User 404");
        }

        return new UserPrinciple(user);
    }
}
