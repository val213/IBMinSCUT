drop table if exists user;
CREATE TABLE `user` (
                        `id` char(19) NOT NULL COMMENT '用户ID',
                        `username` varchar(16) NOT NULL COMMENT '用户名',
                        `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
                        `password` varchar(32) NOT NULL COMMENT '密码',
                        `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                        `role_list` varchar(255) NOT NULL COMMENT '角色',
                        `current_role` varchar(50) NOT NULL COMMENT '当前角色',
                        `department_id` char(19) NOT NULL COMMENT '所属部门ID',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

drop table if exists department;
CREATE TABLE `department` (
                        `id` CHAR(19) NOT NULL COMMENT '部门ID',
                        `name` VARCHAR(255) NOT NULL COMMENT '部门名称',
                        `create_at` timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

drop table if exists `event`;
CREATE TABLE `event` (
                         `id` char(19) NOT NULL COMMENT '事件ID',
                         `name` VARCHAR(255) NOT NULL COMMENT '事件名称',
                        `create_at` timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
                        `start_time` datetime NOT NULL COMMENT '开始时间',
                        `end_time` datetime NOT NULL COMMENT '结束时间',
                        `comment` varchar(255) DEFAULT NULL COMMENT '备注',
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

insert into department (id, name) values ('1', '主席团');
insert into department (id, name) values ('2', '技术部');
insert into department (id, name) values ('3', '组织部');
insert into department (id, name) values ('4', '宣传部');
insert into department (id, name) values ('5', '俱乐部成员');

insert into user (id, username, email, password, role_list, current_role, department_id) values ('1','admin', '1042594899@qq.com', '123456','president,', 'admin', '1');
insert into user (id, username, email, password, role_list, current_role, department_id) values ('2','user1', '111@gmail.com', '123456','minister,', 'user', '1,2');
insert into user (id, username, email, password, role_list, current_role, department_id) values ('3','user2', '222@qq.com`', '123456','core_member,', 'user', '3');
insert into user (id, username, email, password, role_list, current_role, department_id) values ('4','user3', '333@qq.com', '123456','member,', 'user', '5');


insert into event (id, name, start_time, end_time, comment) values ('1', '活动1', '2021-06-01 00:00:00', '2021-06-02 00:00:00', '活动1备注');
insert into event (id, name, start_time, end_time, comment) values ('2', '活动2', '2021-06-03 00:00:00', '2021-06-04 00:00:00', '活动2备注');
insert into event (id, name, start_time, end_time, comment) values ('3', '活动3', '2021-06-05 00:00:00', '2021-06-06 00:00:00', '活动3备注');


ALTER TABLE user MODIFY password VARCHAR(255);
ALTER TABLE user MODIFY id INT AUTO_INCREMENT;
ALTER TABLE user MODIFY role_list VARCHAR(255) DEFAULT '';
ALTER TABLE user MODIFY current_role VARCHAR(50) DEFAULT '';
ALTER TABLE user MODIFY department_id VARCHAR(19) DEFAULT '';