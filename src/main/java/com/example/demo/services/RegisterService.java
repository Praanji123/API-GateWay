package com.example.demo.services;

import com.example.demo.dto.RegisterRequestDTO;
import com.example.demo.dto.RegisterResponseDTO;

public interface RegisterService {
    RegisterResponseDTO registerUser(RegisterRequestDTO userRequestDto);
}