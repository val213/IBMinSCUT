package com.example.backend.mapper;

import com.example.backend.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    
    @Select("SELECT * FROM user WHERE id = #{id}")
    User getUserById(int id);

    /**
     * 查询用户数据
     * @return 用户列表
     */
    @Select("select * from user")
    List<User> list();
}