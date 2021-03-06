package com.example.demo.services.impl;

import com.example.demo.dto.RegisterRequestDTO;
import com.example.demo.dto.RegisterResponseDTO;
import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.RegisterService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterServiceimpl implements RegisterService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public RegisterResponseDTO registerUser(RegisterRequestDTO userRequestDto) {
        Users users = new Users();
        RegisterResponseDTO responseDto = new RegisterResponseDTO();
        List<String> emailList = userRepository.getAllUsersByEmail();
        if(emailList.contains(userRequestDto.getEmail()))
        {
            responseDto.setMessage("Email already Exists");
        }
        //copy fields from dto to employee
        else {
            BeanUtils.copyProperties(userRequestDto, users);
            String hashedpassword = userRequestDto.getPassword();
//            String hashedpassword = DigestUtils.sha256Hex(userRequestDto.getPassword());
            users.setPassword(hashedpassword);
//            Login login = new Login();
//            login.setEmail(users.getEmail());
//            login.setPassword(hashedpassword);
            //save employee to db
            Users savedUsers = userRepository.save(users);
//            loginRepository.save(login);
            // copy from employee to response dto
            //BeanUtils.copyProperties(savedUsers, responseDto);
            responseDto.setMessage("Registration Successful");
        }

        return responseDto;
    }
}