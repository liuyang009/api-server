/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 01/06/2018 22:09:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon_cls` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` bigint(20) NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_num` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK2jrf4gb0gjqi8882gxytpxnhe`(`parent_id`) USING BTREE,
  CONSTRAINT `FK2jrf4gb0gjqi8882gxytpxnhe` FOREIGN KEY (`parent_id`) REFERENCES `sys_menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '', '', '所有', NULL, '', '/', 1);
INSERT INTO `sys_menu` VALUES (5, 'Home', 'el-icon-location-outline', '基础服务', 1, '/home', '/', 2);
INSERT INTO `sys_menu` VALUES (6, 'ShopBasic', NULL, '热门活动管理', 9, '/shop/basic', '/shop/list', 1);
INSERT INTO `sys_menu` VALUES (7, 'UserBasic', NULL, '用户管理', 5, '/user/basic', '/user/list', 1);
INSERT INTO `sys_menu` VALUES (8, 'RoleBasic', NULL, '角色管理', 5, '/role/basic', '/role/list', 2);
INSERT INTO `sys_menu` VALUES (9, 'Home', 'el-icon-location-outline', '卡劵管理', 1, '/home', '/', 1);
INSERT INTO `sys_menu` VALUES (10, 'InvoicBasic', NULL, '进销存管理', 9, '/invoic/basic', NULL, 2);
INSERT INTO `sys_menu` VALUES (11, 'Home', 'el-icon-location-outline', '代理商管理', 1, '/home', '/', 3);
INSERT INTO `sys_menu` VALUES (12, 'ProxyBasic', NULL, '代理商列表', 11, '/proxy/basic', '/proxy/list', 1);
INSERT INTO `sys_menu` VALUES (13, 'VoucherBasic', NULL, '兑换券管理', 9, '/voucher/basic', '', 3);
INSERT INTO `sys_menu` VALUES (14, 'ChannelBasic', NULL, '渠道管理', 9, '/channel/basic', NULL, 4);
INSERT INTO `sys_menu` VALUES (15, 'Home', 'el-icon-location-outline', '商品管理', 1, '/home', '/', 4);
INSERT INTO `sys_menu` VALUES (16, 'ItemBasic', NULL, '商品列表', 15, '/item/basic', NULL, 1);
INSERT INTO `sys_menu` VALUES (17, 'ItemTypeBasic', NULL, '商品分类', 15, '/typeItem/basic', NULL, 2);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name_zh` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (2, 'admin', '超级管理员');
INSERT INTO `sys_role` VALUES (3, 'market', '市场部经理');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_id` bigint(20) NULL DEFAULT NULL,
  `role_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (4, 6, 3);
INSERT INTO `sys_role_menu` VALUES (27, 6, 2);
INSERT INTO `sys_role_menu` VALUES (28, 10, 2);
INSERT INTO `sys_role_menu` VALUES (29, 13, 2);
INSERT INTO `sys_role_menu` VALUES (30, 14, 2);
INSERT INTO `sys_role_menu` VALUES (31, 7, 2);
INSERT INTO `sys_role_menu` VALUES (32, 8, 2);
INSERT INTO `sys_role_menu` VALUES (33, 12, 2);
INSERT INTO `sys_role_menu` VALUES (34, 16, 2);
INSERT INTO `sys_role_menu` VALUES (35, 17, 2);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `birth` datetime(0) NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` bigint(20) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `user_id_create` bigint(20) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '2018-05-01 00:00:00', '123456789@qq.com', '2018-05-15 15:13:33', '2018-05-24 13:44:33', '18023456544', '测试', '111111', NULL, 1, NULL, 'test');
INSERT INTO `sys_user` VALUES (3, '2018-05-01 00:00:00', '987654321@qq.com', '2018-05-16 09:54:52', '2018-05-24 13:44:17', '18011112222', '测试2', '123456', NULL, 0, NULL, 'test2');
INSERT INTO `sys_user` VALUES (4, '2018-05-17 00:00:00', '789@qq.com', '2018-05-17 17:28:14', NULL, '18023232222', '测试3', '123456', NULL, 1, NULL, 'test3');
INSERT INTO `sys_user` VALUES (5, '2018-05-17 00:00:00', '4@qq.com', '2018-05-17 17:34:02', NULL, '18044443333', '测试4', '123456', NULL, 1, NULL, 'test4');
INSERT INTO `sys_user` VALUES (6, '2018-05-17 00:00:00', '5@qq.com', '2018-05-17 17:34:42', '2018-05-18 09:02:09', '18055554444', '测试5', '123456', NULL, 1, NULL, 'test5');
INSERT INTO `sys_user` VALUES (7, '2018-05-18 00:00:00', '6@qq.com', '2018-05-18 16:31:01', NULL, '18066665555', '测试6', '123456', NULL, 1, NULL, 'test6');
INSERT INTO `sys_user` VALUES (8, '2018-05-18 00:00:00', '7@qq.com', '2018-05-18 16:37:43', NULL, '18077774444', '测试7', '123456', NULL, 1, NULL, 'test7');
INSERT INTO `sys_user` VALUES (9, '2018-05-18 00:00:00', '8@qq.com', '2018-05-18 16:38:11', NULL, '18088882222', '测试8', '123456', NULL, 1, NULL, 'test8');
INSERT INTO `sys_user` VALUES (10, '2018-05-18 00:00:00', '9@qq.com', '2018-05-18 16:38:36', NULL, '18099995555', '测试9', '123456', NULL, 1, NULL, 'test9');
INSERT INTO `sys_user` VALUES (11, '2018-05-18 00:00:00', '10@qq.com', '2018-05-18 16:39:09', NULL, '18022225454', '测试10', '123456', NULL, 1, NULL, 'test10');
INSERT INTO `sys_user` VALUES (12, '2018-05-18 00:00:00', '11@qq.com', '2018-05-18 16:39:33', '2018-05-24 13:44:40', '18011112222', '测试11', '123456', NULL, 0, NULL, 'test11');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 3, 4);
INSERT INTO `sys_user_role` VALUES (2, 3, 5);
INSERT INTO `sys_user_role` VALUES (4, 3, 6);
INSERT INTO `sys_user_role` VALUES (5, 3, 7);
INSERT INTO `sys_user_role` VALUES (6, 3, 8);
INSERT INTO `sys_user_role` VALUES (7, 3, 9);
INSERT INTO `sys_user_role` VALUES (8, 3, 10);
INSERT INTO `sys_user_role` VALUES (9, 3, 11);
INSERT INTO `sys_user_role` VALUES (13, 3, 3);
INSERT INTO `sys_user_role` VALUES (14, 2, 1);
INSERT INTO `sys_user_role` VALUES (15, 3, 12);

-- ----------------------------
-- Table structure for tb_channel
-- ----------------------------
DROP TABLE IF EXISTS `tb_channel`;
CREATE TABLE `tb_channel`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_channel
-- ----------------------------
INSERT INTO `tb_channel` VALUES (1, '线下招商平台', '1');

-- ----------------------------
-- Table structure for tb_item_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_item_type`;
CREATE TABLE `tb_item_type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `create_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_item_type
-- ----------------------------
INSERT INTO `tb_item_type` VALUES (1, '2018-06-01 16:40:57', 'test', '海鲜');
INSERT INTO `tb_item_type` VALUES (2, '2018-06-01 16:59:05', 'test', '大闸蟹');


