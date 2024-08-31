package com.example.backend.pojo;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "user") // 映射到数据库中的 "user" 表
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键，自增
    private Long id;


    
    @Column(length = 19, nullable = false, unique = true) // 用户名字段，不能为空，且唯一
    private String username;

   
    @Column(length = 255, nullable = false, unique = true) // 邮箱字段，不能为空，且唯一
    private String email;

    
    @Column(length = 32, nullable = false) // 密码字段，不能为空
    private String password;


    @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME")
    private Date createdAt;




    // 无参构造函数
    public User() {
        this.createdAt = new Date();
    }

    // 有参构造函数
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdAt = new Date(); // 默认使用当前时间
    }

    // Getter 与 Setter 方法

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    // toString 方法，隐藏密码以保护隐私
    @Override
    public String toString() {
        return "User{" +

                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + (password != null ? "*******" : null) + '\'' +
                '}';
    }

    // equals 方法，用于对象比较
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return
                Objects.equals(username, user.username) &&
                        Objects.equals(email, user.email);
    }

    // hashCode 方法，用于集合中的哈希存储
    @Override
    public int hashCode() {
        return Objects.hash( username, email);
    }
}