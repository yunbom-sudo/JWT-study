package com.example.king.domain.auth.user.service;

import com.example.king.domain.auth.user.dto.request.SignUpRequest;
import com.example.king.domain.auth.user.dto.response.SignUpResponse;
import com.example.king.domain.auth.user.entity.User;
import com.example.king.domain.auth.user.repository.UserRepository;
import com.example.king.global.exception.BusinessException;
import com.example.king.global.exception.ErrorCode;
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

        if(userRepository.findByUsername(request.username()).isPresent()){
            throw new BusinessException(ErrorCode.DUPLICATE_USERNAME);
        }

        String encodedPassword = bCryptPasswordEncoder.encode(request.password());

        User savedUser = userRepository.save(request.toEntity(encodedPassword));

        return new SignUpResponse(savedUser);
    }
}
