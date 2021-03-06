package com.example.demo.services;

import com.example.demo.entity.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface LoginService extends UserDetailsService {
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;

    UserDetails loadUserById(Long user_id);
}