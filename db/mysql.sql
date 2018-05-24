/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-05-24 18:12:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `component` varchar(255) DEFAULT NULL,
  `icon_cls` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2jrf4gb0gjqi8882gxytpxnhe` (`parent_id`),
  CONSTRAINT `FK2jrf4gb0gjqi8882gxytpxnhe` FOREIGN KEY (`parent_id`) REFERENCES `sys_menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '', '', '所有', null, '', '/');
INSERT INTO `sys_menu` VALUES ('5', 'Home', 'el-icon-location-outline', '基础服务', '1', '/home', '/');
INSERT INTO `sys_menu` VALUES ('6', 'ShopBasic', null, '热门活动管理', '9', '/shop/basic', '/shop/list');
INSERT INTO `sys_menu` VALUES ('7', 'UserBasic', null, '用户管理', '5', '/user/basic', '/user/list');
INSERT INTO `sys_menu` VALUES ('8', 'RoleBasic', null, '角色管理', '5', '/role/basic', '/role/list');
INSERT INTO `sys_menu` VALUES ('9', 'Home', 'el-icon-location-outline', '首页', '1', '/home', '/');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `name_zh` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('2', 'admin', '超级管理员');
INSERT INTO `sys_role` VALUES ('3', 'market', '市场部经理');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '6', '2');
INSERT INTO `sys_role_menu` VALUES ('2', '7', '2');
INSERT INTO `sys_role_menu` VALUES ('3', '8', '2');
INSERT INTO `sys_role_menu` VALUES ('4', '6', '3');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `birth` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` bigint(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `user_id_create` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '2018-05-01 00:00:00', '123456789@qq.com', '2018-05-15 15:13:33', '2018-05-24 13:44:33', '18023456544', '测试', '123456', null, '1', null, 'test');
INSERT INTO `sys_user` VALUES ('3', '2018-05-01 00:00:00', '987654321@qq.com', '2018-05-16 09:54:52', '2018-05-24 13:44:17', '18011112222', '测试2', '123456', null, '0', null, 'test2');
INSERT INTO `sys_user` VALUES ('4', '2018-05-17 00:00:00', '789@qq.com', '2018-05-17 17:28:14', null, '18023232222', '测试3', '123456', null, '1', null, 'test3');
INSERT INTO `sys_user` VALUES ('5', '2018-05-17 00:00:00', '4@qq.com', '2018-05-17 17:34:02', null, '18044443333', '测试4', '123456', null, '1', null, 'test4');
INSERT INTO `sys_user` VALUES ('6', '2018-05-17 00:00:00', '5@qq.com', '2018-05-17 17:34:42', '2018-05-18 09:02:09', '18055554444', '测试5', '123456', null, '1', null, 'test5');
INSERT INTO `sys_user` VALUES ('7', '2018-05-18 00:00:00', '6@qq.com', '2018-05-18 16:31:01', null, '18066665555', '测试6', '123456', null, '1', null, 'test6');
INSERT INTO `sys_user` VALUES ('8', '2018-05-18 00:00:00', '7@qq.com', '2018-05-18 16:37:43', null, '18077774444', '测试7', '123456', null, '1', null, 'test7');
INSERT INTO `sys_user` VALUES ('9', '2018-05-18 00:00:00', '8@qq.com', '2018-05-18 16:38:11', null, '18088882222', '测试8', '123456', null, '1', null, 'test8');
INSERT INTO `sys_user` VALUES ('10', '2018-05-18 00:00:00', '9@qq.com', '2018-05-18 16:38:36', null, '18099995555', '测试9', '123456', null, '1', null, 'test9');
INSERT INTO `sys_user` VALUES ('11', '2018-05-18 00:00:00', '10@qq.com', '2018-05-18 16:39:09', null, '18022225454', '测试10', '123456', null, '1', null, 'test10');
INSERT INTO `sys_user` VALUES ('12', '2018-05-18 00:00:00', '11@qq.com', '2018-05-18 16:39:33', '2018-05-24 13:44:40', '18011112222', '测试11', '123456', null, '0', null, 'test11');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '3', '4');
INSERT INTO `sys_user_role` VALUES ('2', '3', '5');
INSERT INTO `sys_user_role` VALUES ('4', '3', '6');
INSERT INTO `sys_user_role` VALUES ('5', '3', '7');
INSERT INTO `sys_user_role` VALUES ('6', '3', '8');
INSERT INTO `sys_user_role` VALUES ('7', '3', '9');
INSERT INTO `sys_user_role` VALUES ('8', '3', '10');
INSERT INTO `sys_user_role` VALUES ('9', '3', '11');
INSERT INTO `sys_user_role` VALUES ('13', '3', '3');
INSERT INTO `sys_user_role` VALUES ('14', '2', '1');
INSERT INTO `sys_user_role` VALUES ('15', '3', '12');
