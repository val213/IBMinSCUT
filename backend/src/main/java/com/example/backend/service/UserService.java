package com.example.backend.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.backend.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    
    List<User> list();
}