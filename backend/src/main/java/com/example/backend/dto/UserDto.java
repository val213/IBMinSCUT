package com.example.backend.dto;


import java.time.LocalDateTime;
import java.util.Date;

public class UserDto {
    private String email;
    private String username;
    private String password;//存储封装用户提交的用户名与密码
    private Date createdAt;

    //构造函数，允许用户初始化账户名、密码、邮箱
    public UserDto(){}
    public UserDto(String username,String password,String email){
      this.username=username;
      this.password=password;
      this.email=email;
    }

    // Getter与Setter
    public String getUsername() {return username;}
    public void setUsername(String username)
    {
        this.username=username;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password )
    {
        this.password=password;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public Date getCreatedAt() {return createdAt;}
    public void setCreatedAt(Date createdAt) {this.createdAt = createdAt;}


    @Override//打印UserDto对象时提供字符串表示，并保护隐私
    public String toString() {
        return "UserDto{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + (password != null ? "*******" : null) + '\'' +
                '}';
    }


    @Override//用来比较两个UserDto对象是否相等，用来判断是否是同一个用户
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        UserDto userDto = (UserDto) obj;
        return (username != null ? username.equals(userDto.username) : userDto.username == null) &&
               (email != null ? email.equals(userDto.email) : userDto.email == null);
    }

    @Override//重载equals后附带的，避免冲突
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}