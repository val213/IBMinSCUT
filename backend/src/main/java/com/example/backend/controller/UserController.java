package com.example.backend.controller;

import com.example.backend.dto.LoginRequestDto;
import com.example.backend.dto.LoginResponseDto;
import com.example.backend.dto.UserDto;
import com.example.backend.pojo.User;
import com.example.backend.service.UserService;
import com.example.backend.pojo.Result;
import java.util.List;

// import javax.naming.spi.DirStateFactory.Result;

import com.example.backend.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;// 换了一个logger类的库

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.servlet.http.HttpServletRequest;



@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;
    public static final Logger log = LoggerFactory.getLogger(UserController.class);

    // 获取用户的基本信息
    @GetMapping("/user")
    public ResponseEntity<Result> getUserInfo(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Result.failure("未提供有效的JWT令牌"));
        }

        String jwtToken = token.substring(7); // 去掉 "Bearer " 前缀
        try {
            // 验证JWT令牌的有效性
            String username = jwtUtil.extractUsername(jwtToken);

            if (username == null || !jwtUtil.validateToken(jwtToken, username)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Result.failure("JWT令牌无效"));
            }

            // 从数据库中获取用户信息
            User user = userService.findByUsername(username);
            if (user == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Result.failure("用户不存在"));
            }

            // 返回用户的基本信息
            UserDto userDto = new UserDto();
            userDto.setUsername(user.getUsername());
            userDto.setEmail(user.getEmail());
            userDto.setPassword(user.getPassword());
            userDto.setCreatedAt(user.getCreatedAt()); // 假设 User 类中有注册时间字段

            return ResponseEntity.ok(Result.success(userDto));

        } catch (Exception e) {
            log.error("获取用户信息时发生错误", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Result.failure("无法获取用户信息"));
        }
    }

    // 接收用户相关属性，完成注册
    @PostMapping("/register")
    public ResponseEntity<Result> registerUser(@RequestBody User user) {
        log.info("注册新用户，用户名：{}", user.getUsername());
        try {
            if (userService.isUsernameExists(user.getUsername())) {
                return ResponseEntity.badRequest().body(Result.failure("用户名已存在"));
            }
            if (userService.isPasswordValid(user.getPassword())) {
                return ResponseEntity.badRequest().body(Result.failure("密码不符合要求"));
            }

            User registeredUser = userService.registerNewUser(user.getUsername(), user.getPassword(), user.getEmail());
            return ResponseEntity.ok(Result.success("用户注册成功"));
        } catch (Exception e) {
            log.error("注册用户时发生错误", e);
            return ResponseEntity.internalServerError().body(Result.failure("注册失败：" + e.getMessage()));
        }
    }


    // 接收前端信息，验证，完成登录
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> loginUser(@RequestBody LoginRequestDto loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        if (userService.validateUserCredentials(username, password)) {
            String jwtToken = userService.generateJwtToken(username);// 生成JWT令牌
            LoginResponseDto responseDto = new LoginResponseDto();
            responseDto.setToken(jwtToken);// JWT令牌封装给responsedto，返回给前端
            log.info("Login successful, JWT generated for user: " + username);
            return ResponseEntity.ok(responseDto);
        } else {
            log.warn("Login failed for user: " + username);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }



    @PutMapping("/update")
    public ResponseEntity<Result> updateUserInfo(HttpServletRequest request, @RequestBody UserDto userDto) {

        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Result.failure("未提供有效的JWT令牌"));
        }
        String jwtToken = token.substring(7);
        try {
            // 验证JWT令牌的有效性
            String username = jwtUtil.extractUsername(jwtToken);

            if (username == null || !jwtUtil.validateToken(jwtToken, username)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Result.failure("JWT令牌无效"));
            }

            // 从数据库中获取用户信息
            User user = userService.findByUsername(username);
            if (user == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Result.failure("用户不存在"));
            }
            // 验证新的用户信息
            if (!userService.isEmailValid(userDto.getEmail())) {
                return ResponseEntity.badRequest().body(Result.failure("无效的邮箱格式"));
            }
            if (!userService.isPasswordValid(userDto.getPassword())) {
                return ResponseEntity.badRequest().body(Result.failure("无效的邮箱格式"));
            }
            // 更新用户信息
            user.setEmail(userDto.getEmail());
            user.setPassword(userService.encodePassword(userDto.getPassword()));  // 加密密码

            userService.updateUser(user);  // 更新数据库中的用户信息

            return ResponseEntity.ok(Result.success("用户信息更新成功"));

        } catch (Exception e) {
            log.error("更新用户信息时发生错误", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Result.failure("更新失败：" + e.getMessage()));
        }


    }
}



