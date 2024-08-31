package com.example.backend.controller;

import com.example.backend.pojo.User;
import com.example.backend.service.UserService;
import com.example.backend.pojo.Result;
import java.util.List;

// import javax.naming.spi.DirStateFactory.Result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;// 换了一个logger类的库

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
