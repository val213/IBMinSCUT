package com.example.backend.dto;

// 响应登录请求的Dto类
public class LoginResponseDto {
    private String token;

    // 存储JWT令牌
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}