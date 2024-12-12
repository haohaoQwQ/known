/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 90001
 Source Host           : localhost:3306
 Source Schema         : known

 Target Server Type    : MySQL
 Target Server Version : 90001
 File Encoding         : 65001

 Date: 11/12/2024 09:26:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for chapter
-- ----------------------------
DROP TABLE IF EXISTS `chapter`;
CREATE TABLE `chapter`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `chapter_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `course_id` int NOT NULL,
  `chapter_path` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `chapter_fk01`(`course_id` ASC) USING BTREE,
  CONSTRAINT `chapter_fk01` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of chapter
-- ----------------------------
INSERT INTO `chapter` VALUES (1, 'Java初体验', 1, 'Java初体验');
INSERT INTO `chapter` VALUES (2, '变量和常量', 1, '变量和常量');
INSERT INTO `chapter` VALUES (3, '常用的运算符', 1, '常用的运算符');
INSERT INTO `chapter` VALUES (4, '流程控制语句', 1, '流程控制语句');
INSERT INTO `chapter` VALUES (5, 'Java循环语句', 2, 'Java循环语句');
INSERT INTO `chapter` VALUES (6, '变量和常量', 2, '变量和常量');
INSERT INTO `chapter` VALUES (7, 'Java集合', 2, 'Java集合');
INSERT INTO `chapter` VALUES (8, '异常处理', 2, '异常处理');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `video_id` int NOT NULL,
  `content` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `focus` int NULL DEFAULT NULL,
  `time` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk03`(`user_id` ASC) USING BTREE,
  INDEX `fk04`(`video_id` ASC) USING BTREE,
  CONSTRAINT `fk03` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_course` FOREIGN KEY (`video_id`) REFERENCES `video` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 1, 1, '这个教学真的不错。', NULL, '2019-09-02 22:17:27');
INSERT INTO `comment` VALUES (2, 1, 1, '哈哈哈，我又看了一遍，', NULL, '2020-05-09 08:12:06');
INSERT INTO `comment` VALUES (3, 2, 1, '老师讲的挺好的，很容易懂', NULL, '2020-05-09 08:13:38');
INSERT INTO `comment` VALUES (4, 2, 1, '哈哈哈', NULL, '2020-05-09 08:13:56');
INSERT INTO `comment` VALUES (17, 3, 1, '123', NULL, '2020-05-09 09:27:49');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `course_path` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '',
  `direction` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `level` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `isfress` int NULL DEFAULT NULL,
  `price` double(10, 2) NULL DEFAULT NULL,
  `pic` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT 'course01.jpg',
  `course_status` int NOT NULL DEFAULT 0 COMMENT '0不推荐1推荐',
  `tid` int NOT NULL,
  `focus` int NULL DEFAULT 0,
  `start_time` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '0',
  `time` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '0',
  `introduction` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '欢迎前来观看',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_teacher`(`tid` ASC) USING BTREE,
  CONSTRAINT `fk_teacher` FOREIGN KEY (`tid`) REFERENCES `teacher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, 'Java入门第一季', 'Java入门第一季', 'Java', '高级', 0, 200.00, 'course03.jpg', 1, 2, 0, '2008/8/8', '3', '欢迎前来观看');
INSERT INTO `course` VALUES (2, 'Java入门第二季', 'Java入门第二季', 'Java', '高级', 1, 0.00, 'course03.jpg', 0, 2, 0, '2015/6/7', '3', '欢迎前来观看');
INSERT INTO `course` VALUES (3, 'Java入门第三季', '流行音乐', 'Java', '初级', 0, 300.00, 'course03.jpg', 0, 2, 0, '2018/8/26', '3', '欢迎前来观看');
INSERT INTO `course` VALUES (4, 'Java多线程\r\n', 'Java多线程', 'Java', '中级', 1, 0.00, 'course01.jpg', 1, 3, 0, '2016/10/12', '5', '欢迎前来观看');
INSERT INTO `course` VALUES (5, 'JavaScript入门篇', 'JavaScript入门篇', 'JavaScript', '初级', 1, 0.00, 'course04.jpg', 1, 1, 0, '2017/11/12', '3', '欢迎前来观看');
INSERT INTO `course` VALUES (6, '初识Python', '初识Python', 'Python', '初级', 1, 0.00, 'course01.jpg', 0, 1, 0, '2016/1/9', '2', '欢迎前来观看');
INSERT INTO `course` VALUES (7, 'Springboot入门基础', 'Springboot入门基础', 'SpringBoot', '高级', 0, 0.00, 'course02.jpg', 1, 4, 0, '2016/1/9', '2', '欢迎前来观看');
INSERT INTO `course` VALUES (8, 'MySQL入门基础', 'MySQL入门基础', 'MySQL', '初级', 0, 0.00, 'mysql.jpg', 0, 4, 0, '2016/2/12', '2', '欢迎前来观看');
INSERT INTO `course` VALUES (9, 'MySQL进阶', 'MySQL进阶', 'MySQL', '中级', 0, 0.00, 'mysql.jpg', 0, 3, 0, '2019/10/11', '3', '欢迎前来观看');

-- ----------------------------
-- Table structure for replay_comment
-- ----------------------------
DROP TABLE IF EXISTS `replay_comment`;
CREATE TABLE `replay_comment`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `comment_id` int NOT NULL,
  `answer_id` int NOT NULL,
  `replayed_id` int NOT NULL,
  `content` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `focus` int NULL DEFAULT 0,
  `date` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_co`(`comment_id` ASC) USING BTREE,
  INDEX `fk_answer`(`answer_id` ASC) USING BTREE,
  INDEX `fk_replayer`(`replayed_id` ASC) USING BTREE,
  CONSTRAINT `fk_answer` FOREIGN KEY (`answer_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_co` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_replayer` FOREIGN KEY (`replayed_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of replay_comment
-- ----------------------------
INSERT INTO `replay_comment` VALUES (1, 1, 2, 1, '知音啊，加个好友吧', 0, '2019-09-02 22:17:27');
INSERT INTO `replay_comment` VALUES (3, 1, 1, 2, '是哦，我也喜欢这种教学方式', 0, '2019-09-06 15:04:26');
INSERT INTO `replay_comment` VALUES (4, 1, 1, 2, '这个老师讲的很细，声音也好听，哈哈哈', 0, '2019-09-10 09:15:16');
INSERT INTO `replay_comment` VALUES (5, 1, 2, 1, '我也这么觉得', 0, '2019-09-10 09:16:47');
INSERT INTO `replay_comment` VALUES (8, 1, 3, 1, 'hhh', 0, '2019-09-11 10:11:21');
INSERT INTO `replay_comment` VALUES (9, 1, 3, 2, 'eee', 0, '2019-09-11 10:11:37');
INSERT INTO `replay_comment` VALUES (12, 1, 3, 2, 'hhh', 0, '2019-09-11 11:33:32');
INSERT INTO `replay_comment` VALUES (14, 1, 3, 1, '对呀，我也觉得', 0, '2019-09-11 17:10:34');
INSERT INTO `replay_comment` VALUES (15, 1, 3, 2, '哈哈哈', 0, '2019-09-11 19:58:26');
INSERT INTO `replay_comment` VALUES (16, 4, 3, 2, '321', 0, '2020-05-09 09:27:56');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `tname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `major` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `introduction` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '',
  `teacher_status` int NOT NULL DEFAULT 0 COMMENT '0不推荐1推荐',
  `avatar` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT 'curry.jpg',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, 'Mary', '女', 31, 'Web前端工程师', 'hello, i am Mary, i like web', 1, 'mary.jpg');
INSERT INTO `teacher` VALUES (2, 'Peter', '男', 28, 'Java开发工程师', 'hello, i am Peter, i like java', 1, 'peter02.jpg');
INSERT INTO `teacher` VALUES (3, 'Jack', '男', 44, '全栈工程师', 'hello,everybody,i am Jack', 1, 'jack02.jpg');
INSERT INTO `teacher` VALUES (4, 'Lily', '女', 29, '软件工程师', 'hello, i am Lily, i like coding', 1, 'lily.jpg');
INSERT INTO `teacher` VALUES (5, '123', '女', 22, '学习', '123', 0, 'curry.jpg');
INSERT INTO `teacher` VALUES (6, '111', '女', 11, 'web前端工程师', '111', 0, 'curry.jpg');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `isAdmin` int NOT NULL DEFAULT 0,
  `username` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT 18,
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT 'default.jpg',
  `study_direction` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '学习',
  `phone` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '110',
  `email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '123.com',
  `motto` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `account` int NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 0, 'mike', '123', '男', 18, '江西南昌', '1.jpg', '运动', '19970437310', '1045112166@qq.com', '我是一个爱学习的好孩子', 1000);
INSERT INTO `user` VALUES (2, 0, 'mary', '123', '女', 16, '江西南昌', '2.jpg', '学习', '15870902823', '1025788012@qq.com', '我的小仙女', 1000);
INSERT INTO `user` VALUES (3, 0, 'haoge', '123', '男', 22, '江西南昌', '3.jpg', '运动', '15347908269', '1551316289@qq.comm', '我喜欢打篮球', 1000);
INSERT INTO `user` VALUES (11, 0, 'qiuge', '123', '男', 18, '江西上饶', 'default.jpg', '学习', '110', '123.com', 'hello,我是球哥', 0);
INSERT INTO `user` VALUES (19, 0, 'zhuzhu', '123', '女', 18, '江西南昌', 'default.jpg', '音乐', '18279677444', '1551316289@qq.com', NULL, 0);
INSERT INTO `user` VALUES (35, 1, 'admin', 'admin', '男', 18, NULL, 'default.jpg', '学习', '110', 'admin.com', NULL, 0);
INSERT INTO `user` VALUES (39, 0, 'menghao', '123', '男', 18, '江西南昌', 'default.jpg', '运动', '15347908269', '123.com', NULL, 0);
INSERT INTO `user` VALUES (40, 0, 'root', 'root', '男', 18, NULL, 'default.jpg', '学习', '', '1551316289@qq.com', NULL, 0);

-- ----------------------------
-- Table structure for user_buy_course
-- ----------------------------
DROP TABLE IF EXISTS `user_buy_course`;
CREATE TABLE `user_buy_course`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `course_id` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk05`(`user_id` ASC) USING BTREE,
  INDEX `fk06`(`course_id` ASC) USING BTREE,
  CONSTRAINT `user_buy_course_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_buy_course_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_buy_course
-- ----------------------------
INSERT INTO `user_buy_course` VALUES (21, 3, 4);
INSERT INTO `user_buy_course` VALUES (22, 3, 7);
INSERT INTO `user_buy_course` VALUES (24, 3, 1);

-- ----------------------------
-- Table structure for user_collect_course
-- ----------------------------
DROP TABLE IF EXISTS `user_collect_course`;
CREATE TABLE `user_collect_course`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `course_id` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk05`(`user_id` ASC) USING BTREE,
  INDEX `fk06`(`course_id` ASC) USING BTREE,
  CONSTRAINT `user_collect_course_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_collect_course_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_collect_course
-- ----------------------------
INSERT INTO `user_collect_course` VALUES (21, 3, 4);
INSERT INTO `user_collect_course` VALUES (22, 3, 7);
INSERT INTO `user_collect_course` VALUES (24, 3, 1);

-- ----------------------------
-- Table structure for user_teacher
-- ----------------------------
DROP TABLE IF EXISTS `user_teacher`;
CREATE TABLE `user_teacher`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `teacher_id` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_teacher_fk01`(`user_id` ASC) USING BTREE,
  INDEX `user_teacher_fk02`(`teacher_id` ASC) USING BTREE,
  CONSTRAINT `user_teacher_fk01` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_teacher_fk02` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_teacher
-- ----------------------------
INSERT INTO `user_teacher` VALUES (2, 3, 2);

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `video_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `chapter_id` int NOT NULL,
  `video_path` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `video_fk01`(`chapter_id` ASC) USING BTREE,
  CONSTRAINT `video_fk01` FOREIGN KEY (`chapter_id`) REFERENCES `chapter` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES (1, '1-1 Java简介', 1, '1-1 Java简介');
INSERT INTO `video` VALUES (2, '1-2  Java开发环境搭建  ', 1, '1-2  Java开发环境搭建  ');
INSERT INTO `video` VALUES (3, '1-3  用记事本编写Java程序', 1, '1-3  用记事本编写Java程序');
INSERT INTO `video` VALUES (4, '1-4  练习题    ', 1, '1-4  练习题    ');
INSERT INTO `video` VALUES (5, '1-5  使用Eclipse开发Java程序', 1, '1-5  使用Eclipse开发Java程序');
INSERT INTO `video` VALUES (6, '2-1  Java中的关键字', 2, '2-1  Java中的关键字');
INSERT INTO `video` VALUES (7, '2-2  认识Java标识符', 2, '2-2  认识Java标识符');
INSERT INTO `video` VALUES (8, '3-1  Java中的运算符', 3, '3-1  Java中的运算符');
INSERT INTO `video` VALUES (9, '4-1Java中的条件语句', 4, '4-1Java中的条件语句');

-- ----------------------------
-- Table structure for videoplay_record
-- ----------------------------
DROP TABLE IF EXISTS `videoplay_record`;
CREATE TABLE `videoplay_record`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `video_id` int NOT NULL,
  `time` double(255, 0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of videoplay_record
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
