package com.example.king.domain.user.dto.request;

import com.example.king.domain.user.entity.User;

public record SignUpRequest(
        String username,
        String password
) {

    public User toEntity(String encodedPassword){
        return User.builder()
                .userName(this.username)
                .password(encodedPassword)
                .build();
    }
}
