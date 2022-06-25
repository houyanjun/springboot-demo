CREATE TABLE `user_info_0` (
                          `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
                          `user_name` varchar(50) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '用户名',
                          `password` varchar(255) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '密码',
                          `sex` int NOT NULL DEFAULT 2 COMMENT '性别（0=女，1=男，2=未知）',
                          `createTime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
                          PRIMARY KEY (`id`) USING BTREE,
                          UNIQUE INDEX `userName`(`user_name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT = 'user' ROW_FORMAT = Dynamic;

CREATE TABLE `user_info_1` (
                          `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
                          `user_name` varchar(50) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '用户名',
                          `password` varchar(255) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '密码',
                          `sex` int NOT NULL DEFAULT 2 COMMENT '性别（0=女，1=男，2=未知）',
                          `createTime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
                          PRIMARY KEY (`id`) USING BTREE,
                          UNIQUE INDEX `userName`(`user_name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT = 'user' ROW_FORMAT = Dynamic;

CREATE TABLE `user_info_2` (
                          `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
                          `user_name` varchar(50) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '用户名',
                          `password` varchar(255) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '密码',
                          `sex` int NOT NULL DEFAULT 2 COMMENT '性别（0=女，1=男，2=未知）',
                          `createTime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
                          PRIMARY KEY (`id`) USING BTREE,
                          UNIQUE INDEX `userName`(`user_name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT = 'user' ROW_FORMAT = Dynamic;


