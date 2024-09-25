drop table if exists user;
CREATE TABLE `user` (
                        `id` int NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                        `username` varchar(16) NOT NULL COMMENT '用户名',
                        `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
                        `password` varchar(255) NOT NULL COMMENT '密码',
                        `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                        `role_list` varchar(255) NOT NULL DEFAULT '' COMMENT '角色',
                        `current_role` varchar(50) NOT NULL DEFAULT '' COMMENT '当前角色',
                        `department_id` varchar(19) NOT NULL DEFAULT '' COMMENT '所属部门ID',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

drop table if exists department;
CREATE TABLE `department` (
                              `id` int NOT NULL AUTO_INCREMENT COMMENT '部门ID',
                              `name` VARCHAR(255) NOT NULL COMMENT '部门名称',
                              `create_time` timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

drop table if exists `event`;
CREATE TABLE `event` (
                         `id` int NOT NULL AUTO_INCREMENT COMMENT '事件ID',
                         `name` VARCHAR(255) NOT NULL COMMENT '事件名称',
                         `create_time` timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
                         `start_time` datetime NOT NULL COMMENT '开始时间',
                         `end_time` datetime NOT NULL COMMENT '结束时间',
                         `comment` varchar(255) DEFAULT NULL COMMENT '备注',
                         `status` tinyint(1) DEFAULT 0 COMMENT '状态',
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

insert into department (id, name) values (1, 'Presidium');
insert into department (id, name) values (2, 'Technical Department');
insert into department (id, name) values (3, 'Organization Department');
insert into department (id, name) values (4, 'Publicity Department');
insert into department (id, name) values (5, 'Club Members');

insert into user (id, username, email, password, role_list, current_role, department_id) values (1, 'admin', '1042594899@qq.com', '123456', 'president,', 'admin', '1');
insert into user (id, username, email, password, role_list, current_role, department_id) values (2, 'user1', '111@gmail.com', '123456', 'minister,', 'user', '1,2');
insert into user (id, username, email, password, role_list, current_role, department_id) values (3, 'user2', '222@qq.com', '123456', 'core_member,', 'user', '3');
insert into user (id, username, email, password, role_list, current_role, department_id) values (4, 'user3', '333@qq.com', '123456', 'member,', 'user', '5');

insert into event (id, name, start_time, end_time, comment) values (1, 'Event 1', '2021-06-01 00:00:00', '2021-06-02 00:00:00', 'Event 1 comment');
insert into event (id, name, start_time, end_time, comment) values (2, 'Event 2', '2021-06-03 00:00:00', '2021-06-04 00:00:00', 'Event 2 comment');
insert into event (id, name, start_time, end_time, comment) values (3, 'Event 3', '2021-06-05 00:00:00', '2021-06-06 00:00:00', 'Event 3 comment');