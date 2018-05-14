/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-05-14 17:07:53
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', 'Home', 'el-icon-location-outline', '系统管理', null, '/home', '');
INSERT INTO `sys_menu` VALUES ('2', 'ShopBasic', null, '门店管理', '1', '/shop/basic', '/shop/list');
INSERT INTO `sys_menu` VALUES ('3', 'User', null, '用户管理', '1', '/user/basic', '/user/list');
INSERT INTO `sys_menu` VALUES ('4', 'Role', null, '角色管理', '1', '/role/basic', '/role/list');
