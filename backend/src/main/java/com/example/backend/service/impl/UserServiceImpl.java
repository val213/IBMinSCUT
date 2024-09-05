package com.example.backend.service.impl;

import com.example.backend.mapper.UserMapper;
import com.example.backend.pojo.User;
import com.example.backend.service.UserService;
import com.example.backend.util.JwtUtil;
import java.util.List;

import com.example.backend.util.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.backend.controller.UserController.log;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtUtil jwtUtil;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    public boolean isUsernameExists(String username) {
        return userMapper.findByUsername(username) != null;
    }

    @Override
    public boolean isPasswordValid(String password) {
        // 这里可以添加更复杂的密码验证逻辑
        return password != null;
    }

    @Override
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);// 密码加密
    }

    @Override
    public User registerNewUser(String username, String password, String email) {
        if (isUsernameExists(username)) {
            throw new IllegalArgumentException("用户名已存在");
        }
        if (!isPasswordValid(password)) {
            throw new IllegalArgumentException("密码不符合要求");
        }
        String encodedPassword = encodePassword(password);
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(encodedPassword);// 存储在数据库中的密码是加密过的
        newUser.setEmail(email);
        userMapper.insertUser(newUser);
        return newUser;
    }

    @Override
    public boolean validateUserCredentials(String username, String password) {
        User user = userMapper.findByUsername(username);
        if (user != null) {
            log.debug("User found: " + username + ", encrypted password in DB: " + user.getPassword());
            boolean matches = passwordEncoder.matches(password, user.getPassword());// 用于验证登录时输入的密码经过加密后是否与数据库中存储的密码一致
            log.debug("Password matches: " + matches);
            return matches;
        }
        log.warn("User not found with username: " + username);
        return false;
    }

    @Override
    public String generateJwtToken(String username) {
        return jwtUtil.generateToken(username);// JwtUtil类中生成令牌的逻辑
    }
}


