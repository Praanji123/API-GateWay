package com.example.demo.controller;

import com.example.demo.dto.LoginRequestDTO;
import com.example.demo.dto.LoginResponseDTO;
import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(path = "/hello")
    public String hello() {
        return "hello feefal";
    }

    @PostMapping(path = "/login")
    public LoginResponseDTO createAuthenticationToken(@RequestBody LoginRequestDTO loginRequestDTO) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequestDTO.getEmail(), loginRequestDTO.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect Email or Password", e);
        }

//        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequestDTO.getEmail());

        Users user = userRepository.getUserByEmail(loginRequestDTO.getEmail());

//        String jwt = jwtUtil.generateToken(loginRequestDTO.getEmail());

        String jwt = jwtUtil.generateToken(String.valueOf(user.getUser_id()));

        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        loginResponseDTO.setJwt(jwt);
        loginResponseDTO.setMessage("Success");

        return loginResponseDTO;

    }

}