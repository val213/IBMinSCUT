package com.example.backend.controller;

import com.example.backend.pojo.User;
import com.example.backend.service.UserService;
import com.example.backend.pojo.Result;
import java.util.List;

// import javax.naming.spi.DirStateFactory.Result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;// 换了一个logger类的库

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;



@RestController
public class UserController {
    @Autowired
    private UserService userService;

     private static final Logger log=LoggerFactory.getLogger(UserController.class);

     @GetMapping("/user")
     public Result list(){

        log.info("查询用户信息");
        List<User> users = userService.list();
        return Result.success(users);
     }


    // 接收用户相关属性，完成注册
    @PostMapping("/register")
    public ResponseEntity<Result> registerUser(@RequestBody User user) {
        log.info("注册新用户，用户名：{}", user.getUsername());
        try {
            if (userService.isUsernameExists(user.getUsername())) {
                return ResponseEntity.badRequest().body(Result.failure("用户名已存在"));
            }
            if (!userService.isPasswordValid(user.getPassword())) {
                return ResponseEntity.badRequest().body(Result.failure("密码不符合要求"));
            }

            String encodedPassword = userService.encodePassword(user.getPassword());
            User registeredUser = userService.registerNewUser(user.getUsername(), encodedPassword, user.getEmail());
            return ResponseEntity.ok(Result.success("用户注册成功"));
        } catch (Exception e) {
            log.error("注册用户时发生错误", e);
            return ResponseEntity.internalServerError().body(Result.failure("注册失败：" + e.getMessage()));
        }
    }

}
