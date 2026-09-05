package com.example.king.domain.auth.dto.request;

public record LoginRequest(
        String username,
        String password
) {
}
