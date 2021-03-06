
package com.example.demo.services.impl;

import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LoginServiceimpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users = userRepository.getUserByEmail(email);
        return new User(users.getEmail(), users.getPassword(), new ArrayList<>());
    }

    @Override
    public UserDetails loadUserById(Long user_id) {
        Users users = userRepository.getUserById(user_id);
        return new User(String.valueOf(user_id), users.getPassword(), new ArrayList<>());
    }
}