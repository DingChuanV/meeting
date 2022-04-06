/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : meeting

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 06/04/2022 16:07:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for counter
-- ----------------------------
DROP TABLE IF EXISTS `counter`;
CREATE TABLE `counter` (
  `visitcount` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of counter
-- ----------------------------
BEGIN;
INSERT INTO `counter` VALUES (99);
COMMIT;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `departmentid` int NOT NULL AUTO_INCREMENT,
  `departmentname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`departmentid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of department
-- ----------------------------
BEGIN;
INSERT INTO `department` VALUES (1, '技术部');
INSERT INTO `department` VALUES (2, '人事部');
INSERT INTO `department` VALUES (3, '财务部');
INSERT INTO `department` VALUES (4, '行政部');
INSERT INTO `department` VALUES (7, '运维部');
INSERT INTO `department` VALUES (18, 'test11');
INSERT INTO `department` VALUES (22, 'test2');
COMMIT;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `employeeid` int NOT NULL AUTO_INCREMENT,
  `employeename` varchar(14) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `departmentid` int DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` int DEFAULT NULL,
  PRIMARY KEY (`employeeid`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of employee
-- ----------------------------
BEGIN;
INSERT INTO `employee` VALUES (8, '王晓华', 'wangxh', '13671075406', 'wang@qq.com', 1, 1, '1', 1);
INSERT INTO `employee` VALUES (9, '林耀坤', 'linyk', '13671075406', 'yang@qq.com', 1, 2, '1', 2);
INSERT INTO `employee` VALUES (10, '熊杰文', 'xiongjw', '134555555', 'xiong@qq.com', 1, 3, '1', 2);
INSERT INTO `employee` VALUES (11, '王敏', 'wangmin', '1324554321', 'wangm@qq.com', 2, 4, '1', 2);
INSERT INTO `employee` VALUES (12, '林耀坤', 'linyk', '1547896765', 'kun@qq.com', 1, 7, '1', 2);
INSERT INTO `employee` VALUES (13, '林耀坤', 'linyk', '13897338822', 'yao@qq.com', 1, 1, '2', 2);
INSERT INTO `employee` VALUES (14, '林耀坤', 'linyk', '18908789808', 'yangyk@qq.com', 2, 2, '2', 2);
INSERT INTO `employee` VALUES (15, '黄美玲', 'huangml', 'huangml@qq.com', '13567898765', 1, 3, '1', 2);
INSERT INTO `employee` VALUES (16, '黄美玲', 'huangml', 'huangml@qq.com', '13567898765', 2, 4, '1', 2);
INSERT INTO `employee` VALUES (17, '黄美玲', 'huangml002', 'huangml@qq.com', '13567898765', 2, 1, '1', 2);
INSERT INTO `employee` VALUES (20, '王敏', 'wangmin002', '13454332334', 'wang@qq.com', 1, 4, '1', 2);
INSERT INTO `employee` VALUES (21, '陈敏', 'chenm', '13559994444', 'www@aa.com', 1, 2, '1', 2);
INSERT INTO `employee` VALUES (23, '陈晨', 'wangm', '22·2', '11', 2, 1, '1', 2);
INSERT INTO `employee` VALUES (25, '王晓华', 'wangxh222', '111', '1', 1, 4, '1', 2);
INSERT INTO `employee` VALUES (27, '张三', 'zhangsan', '122', '22', 2, 4, '1', 2);
INSERT INTO `employee` VALUES (29, 'uin', 'uin', '17392867735', '1', 1, 1, '1', 2);
INSERT INTO `employee` VALUES (46, 'test01', 'test01', '17392867735', '2686221966@qq.com', 2, 1, '1', 1);
INSERT INTO `employee` VALUES (47, 'test02', 'test02', '17392867735', '2686221966@qq.com', 2, 18, '1', 1);
COMMIT;

-- ----------------------------
-- Table structure for meeting
-- ----------------------------
DROP TABLE IF EXISTS `meeting`;
CREATE TABLE `meeting` (
  `meetingid` int NOT NULL AUTO_INCREMENT,
  `meetingname` varchar(20) DEFAULT NULL,
  `roomid` int DEFAULT NULL,
  `reservationistid` int DEFAULT NULL,
  `numberofparticipants` int DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `reservationtime` datetime DEFAULT NULL,
  `canceledtime` datetime DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`meetingid`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of meeting
-- ----------------------------
BEGIN;
INSERT INTO `meeting` VALUES (25, 'ces', 5, 8, 12, '2015-01-12 10:00:00', '2015-01-12 12:00:00', '2015-01-10 23:02:39', NULL, NULL, '1');
INSERT INTO `meeting` VALUES (26, '测测', 7, 8, 12, '2015-01-12 13:00:00', '2015-01-12 15:00:00', '2015-01-17 23:04:18', '2015-01-11 01:06:20', NULL, '1');
INSERT INTO `meeting` VALUES (27, '我看看', 6, 8, 12, '2015-01-13 23:06:06', '2015-01-14 03:06:08', '2015-01-10 23:06:33', '2015-01-11 01:01:42', '我看看', '1');
INSERT INTO `meeting` VALUES (28, '运营会', 5, 8, 12, '2015-01-10 23:26:11', '2015-01-11 23:26:13', '2015-01-10 23:26:26', NULL, '测试', '0');
INSERT INTO `meeting` VALUES (29, '市场部会议', 6, 8, 12, '2015-01-10 23:44:22', '2015-01-11 23:44:24', '2015-01-10 23:44:41', NULL, '市场部', '0');
INSERT INTO `meeting` VALUES (30, '内部会议', 10, 8, 12, '2015-01-10 23:55:59', '2015-01-11 23:56:01', '2015-01-10 23:56:20', NULL, '内部会议', '0');
INSERT INTO `meeting` VALUES (31, '我的会议', 9, 8, 12, '2015-01-12 16:33:16', '2015-01-13 16:33:18', '2015-01-11 16:35:11', NULL, '测试', '0');
INSERT INTO `meeting` VALUES (32, '我的会议哈哈', 5, 8, 10, '2015-01-12 16:40:31', '2015-01-13 16:40:35', '2015-01-11 16:40:50', NULL, '', '0');
INSERT INTO `meeting` VALUES (33, '哈哈', 6, 8, 12, '2015-01-12 16:41:45', '2015-01-13 16:41:48', '2015-01-11 16:42:09', '2015-01-12 11:44:57', '你好', '1');
INSERT INTO `meeting` VALUES (34, '我的会议3', 8, 8, 12, '2015-01-11 16:42:36', '2015-01-13 16:42:38', '2015-01-11 16:42:51', NULL, '测试', '0');
INSERT INTO `meeting` VALUES (35, '我的会议', 7, 8, 12, '2015-01-11 16:44:03', '2015-01-11 16:44:05', '2015-01-11 16:44:35', NULL, '', '0');
INSERT INTO `meeting` VALUES (36, '我问问', 7, 8, 12, '2015-01-11 16:56:57', '2015-01-11 16:56:59', '2015-01-11 16:57:56', '2015-01-11 16:59:57', '地点', '1');
INSERT INTO `meeting` VALUES (37, '我的会议4', 7, 8, 12, '2015-01-12 16:59:26', '2015-01-12 16:59:31', '2015-01-11 16:59:49', NULL, '我的会议', '0');
INSERT INTO `meeting` VALUES (38, '班会', 9, 8, 12, '2015-01-15 16:46:25', '2015-01-16 18:46:53', '2015-01-12 11:49:17', '2015-01-12 11:49:37', '班会', '1');
INSERT INTO `meeting` VALUES (39, '测试会议', 5, 8, 12, '2015-01-14 14:41:11', '2015-01-15 14:41:14', '2015-01-14 14:44:07', NULL, 'ss', '0');
INSERT INTO `meeting` VALUES (40, 'test', 5, 29, 12, '2022-04-06 14:41:48', '2022-04-06 14:41:51', '2022-04-06 14:51:38', NULL, '123123123', NULL);
INSERT INTO `meeting` VALUES (41, 'test', 5, 29, 12, '2022-04-06 14:41:48', '2022-04-06 14:41:51', '2022-04-06 14:55:09', NULL, 'test', NULL);
INSERT INTO `meeting` VALUES (42, 'test', 5, 29, 12, '2022-04-06 14:41:48', '2022-04-06 14:41:51', '2022-04-06 14:58:26', NULL, 'test', NULL);
COMMIT;

-- ----------------------------
-- Table structure for meetingparticipants
-- ----------------------------
DROP TABLE IF EXISTS `meetingparticipants`;
CREATE TABLE `meetingparticipants` (
  `meetingid` int NOT NULL,
  `employeeid` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of meetingparticipants
-- ----------------------------
BEGIN;
INSERT INTO `meetingparticipants` VALUES (28, 13);
INSERT INTO `meetingparticipants` VALUES (28, 23);
INSERT INTO `meetingparticipants` VALUES (28, 27);
INSERT INTO `meetingparticipants` VALUES (28, 16);
INSERT INTO `meetingparticipants` VALUES (29, 16);
INSERT INTO `meetingparticipants` VALUES (29, 13);
INSERT INTO `meetingparticipants` VALUES (29, 8);
INSERT INTO `meetingparticipants` VALUES (30, 15);
INSERT INTO `meetingparticipants` VALUES (30, 13);
INSERT INTO `meetingparticipants` VALUES (30, 8);
INSERT INTO `meetingparticipants` VALUES (30, 23);
INSERT INTO `meetingparticipants` VALUES (27, 8);
INSERT INTO `meetingparticipants` VALUES (26, 8);
INSERT INTO `meetingparticipants` VALUES (25, 8);
INSERT INTO `meetingparticipants` VALUES (28, 8);
INSERT INTO `meetingparticipants` VALUES (31, 8);
INSERT INTO `meetingparticipants` VALUES (31, 17);
INSERT INTO `meetingparticipants` VALUES (31, 23);
INSERT INTO `meetingparticipants` VALUES (32, 8);
INSERT INTO `meetingparticipants` VALUES (32, 17);
INSERT INTO `meetingparticipants` VALUES (33, 15);
INSERT INTO `meetingparticipants` VALUES (34, 8);
INSERT INTO `meetingparticipants` VALUES (34, 17);
INSERT INTO `meetingparticipants` VALUES (35, 8);
INSERT INTO `meetingparticipants` VALUES (36, 9);
INSERT INTO `meetingparticipants` VALUES (36, 8);
INSERT INTO `meetingparticipants` VALUES (37, 8);
INSERT INTO `meetingparticipants` VALUES (37, 23);
INSERT INTO `meetingparticipants` VALUES (38, 11);
INSERT INTO `meetingparticipants` VALUES (38, 16);
INSERT INTO `meetingparticipants` VALUES (38, 20);
INSERT INTO `meetingparticipants` VALUES (39, 13);
INSERT INTO `meetingparticipants` VALUES (42, 29);
INSERT INTO `meetingparticipants` VALUES (42, 46);
COMMIT;

-- ----------------------------
-- Table structure for meetingroom
-- ----------------------------
DROP TABLE IF EXISTS `meetingroom`;
CREATE TABLE `meetingroom` (
  `roomid` int NOT NULL AUTO_INCREMENT,
  `roomnum` int NOT NULL,
  `roomname` varchar(20) NOT NULL,
  `capacity` int DEFAULT NULL,
  `status` int DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`roomid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of meetingroom
-- ----------------------------
BEGIN;
INSERT INTO `meetingroom` VALUES (5, 101, '第一会议室', 15, 0, '公共会议室');
INSERT INTO `meetingroom` VALUES (6, 102, '第二会议室', 5, 0, '管理部门会议室');
INSERT INTO `meetingroom` VALUES (7, 103, '第三会议室', 12, 0, '市场部专用会议室');
INSERT INTO `meetingroom` VALUES (8, 401, '第四会议室', 15, 0, '公共会议室');
INSERT INTO `meetingroom` VALUES (9, 201, '第五会议室', 15, 0, '最大会议室');
INSERT INTO `meetingroom` VALUES (10, 601, '第六会议室', 12, 0, '需要提前三天预定');
INSERT INTO `meetingroom` VALUES (11, 201, 'test', 1111, 0, 'test');
INSERT INTO `meetingroom` VALUES (12, 201, 'test1', 1111111, 0, '2222');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
