package com.example.king.domain.user.controller;

import com.example.king.domain.user.dto.request.SignUpRequest;
import com.example.king.domain.user.dto.response.SignUpResponse;
import com.example.king.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public SignUpResponse signup(@RequestBody SignUpRequest request){
        return userService.signUp(request);
    }
}
