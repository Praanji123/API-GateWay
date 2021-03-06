package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDTO {
    private String jwt;
    private String message;

//    public LoginResponseDTO(String jwt) {
//        this.jwt = jwt;
//    }
}