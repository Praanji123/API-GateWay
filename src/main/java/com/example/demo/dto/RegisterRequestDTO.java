package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone_no;
    private String password;
    private String address;

}