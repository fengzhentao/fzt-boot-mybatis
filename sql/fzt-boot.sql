/*
 Navicat Premium Data Transfer

 Source Server         : mydata
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : fzt-boot

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 29/03/2019 17:34:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(100) NOT NULL COMMENT '书名',
  `price` decimal(10,2) NOT NULL COMMENT '单价',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `disabled` bit(1) NOT NULL COMMENT '是否下架',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
BEGIN;
INSERT INTO `book` VALUES (1, '小说', 10.00, '2018-12-27 11:04:45', b'1', 4);
INSERT INTO `book` VALUES (2, '菜谱', 20.00, '2018-12-27 11:05:44', b'1', 4);
INSERT INTO `book` VALUES (3, '1', 1.00, '2019-03-28 15:39:14', b'1', 5);
COMMIT;

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `sex` tinyint(10) NOT NULL COMMENT '年龄',
  `money` decimal(10,0) NOT NULL COMMENT '存款',
  `price` double(10,2) NOT NULL COMMENT '单价',
  `count` float NOT NULL COMMENT '数量',
  `create_time` date NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `disabled` bit(1) NOT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
BEGIN;
INSERT INTO `person` VALUES (2, '??', 1, 0, 0.00, 0, '2018-12-26', '2018-12-26 00:54:44', b'0');
INSERT INTO `person` VALUES (3, '??', 0, 0, 0.00, 0, '2018-12-26', '2018-12-26 03:34:43', b'0');
INSERT INTO `person` VALUES (4, '小王', 0, 0, 0.00, 0, '2018-12-26', '2018-12-26 03:41:21', b'0');
INSERT INTO `person` VALUES (5, '小红', 0, 0, 0.00, 0, '2019-03-27', '2019-03-27 22:33:47', b'0');
INSERT INTO `person` VALUES (6, '小红', 0, 0, 0.00, 0, '2019-03-27', '2019-03-27 22:35:49', b'0');
INSERT INTO `person` VALUES (7, '小红', 0, 0, 0.00, 0, '2019-03-27', '2019-03-27 22:36:11', b'0');
INSERT INTO `person` VALUES (8, '小红', 0, 0, 0.00, 0, '2019-03-28', '2019-03-28 01:14:55', b'0');
INSERT INTO `person` VALUES (9, '小红', 0, 0, 0.00, 0, '2019-03-28', '2019-03-28 04:31:15', b'0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
