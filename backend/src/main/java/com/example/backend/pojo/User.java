package com.example.backend.pojo;

import jakarta.persistence.*;
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

    @Column(name = "update_time", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updateTime;

    @Column(name = "role_list", nullable = true, length = 255)
    private String roleList;

    @Column(name = "current_role", nullable =true, length = 50)
    private String currentRole;

    @Column(name = "department_id", nullable =true, length = 19)
    private String departmentId;


    // 无参构造函数
    public User() {
        this.createdAt = new Date();
    }

    // 有参构造函数
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.roleList = roleList;
        this.currentRole = currentRole;
        this.departmentId = departmentId;
        this.createdAt = new Date(); // 默认使用当前时间
        this.updateTime = new Date(); // 默认使用当前时间
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRoleList() {
        return roleList;
    }

    public void setRoleList(String roleList) {
        this.roleList = roleList;
    }

    public String getCurrentRole() {
        return currentRole;
    }

    public void setCurrentRole(String currentRole) {
        this.currentRole = currentRole;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }


    // toString 方法，隐藏密码以保护隐私
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + (password != null ? "*******" : null) + '\'' +
                ", createdAt=" + createdAt +
                ", updateTime=" + updateTime +
                ", roleList='" + roleList + '\'' +
                ", currentRole='" + currentRole + '\'' +
                ", departmentId='" + departmentId + '\'' +
                '}';
    }

    // equals 方法，用于对象比较
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(email, user.email) &&
                Objects.equals(roleList, user.roleList) &&
                Objects.equals(currentRole, user.currentRole) &&
                Objects.equals(departmentId, user.departmentId);
    }

    // hashCode 方法，用于集合中的哈希存储
    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, roleList, currentRole, departmentId);
    }
}