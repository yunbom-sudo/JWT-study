package com.example.king.domain.user.service;

import com.example.king.domain.user.dto.request.SignUpRequest;
import com.example.king.domain.user.dto.response.SignUpResponse;
import com.example.king.domain.user.entity.User;
import com.example.king.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Transactional
    public SignUpResponse signUp(SignUpRequest request){

        if(userRepository.findByUserName(request.username()).isPresent()){
            throw new RuntimeException("에러 발생!");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(request.password());

        User savedUser = userRepository.save(request.toEntity(encodedPassword));

        return new SignUpResponse(savedUser);
    }
}
