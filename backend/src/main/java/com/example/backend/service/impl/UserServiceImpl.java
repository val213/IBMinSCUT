package com.example.backend.service.impl;

import com.example.backend.mapper.UserMapper;
import com.example.backend.pojo.User;
import com.example.backend.service.UserService;

import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list()
    {
        return userMapper.list();
    }

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public boolean isUsernameExists(String username) {
        return userMapper.findByUsername(username) != null;
    }

    @Override
    public boolean isPasswordValid(String password) {
        // 这里可以添加更复杂的密码验证逻辑
        return password != null ;
    }

    @Override
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
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
        newUser.setPassword(encodedPassword);
        newUser.setEmail(email);
        userMapper.insertUser(newUser);
        return newUser;
    }
}
