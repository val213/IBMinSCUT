CREATE TABLE `user` (
                        `username` varchar(16) NOT NULL COMMENT '用户名',
                        `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
                        `password` varchar(32) NOT NULL COMMENT '密码',
                        `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                        `role_list` varchar(255) NOT NULL COMMENT '角色',
                        `current_role` varchar(50) NOT NULL COMMENT '当前角色'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci