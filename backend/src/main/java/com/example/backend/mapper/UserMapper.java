package com.example.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.backend.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * FROM user WHERE id = #{id}")
    User getUserById(int id);

    /**
     * 查询用户数据
     * @return 用户列表
     */
    @Select("select * from user")
    List<User> list();

    // 按用户名查找的方法
    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUsername(@Param("username") String username);

    // 注册新用户后将新用户数据插入数据库
    @Insert("INSERT INTO user (username, password, email) VALUES (#{username}, #{password}, #{email})")
    void insertUser(User user);

}