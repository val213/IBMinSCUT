package com.example.backend.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.backend.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    
    List<User> list();
    boolean isUsernameExists(String username);
    boolean isPasswordValid(String password);
    boolean isEmailValid(String email);
    String encodePassword(String password);
    User registerNewUser(String username, String encodedPassword, String email);

    // 验证用户凭据
    boolean validateUserCredentials(String username, String password);

    // 生成 JWT 令牌
    String generateJwtToken(String username);

    User findByUsername(String username); // 根据用户名查找用户信息

    void updateUser(User user);
}