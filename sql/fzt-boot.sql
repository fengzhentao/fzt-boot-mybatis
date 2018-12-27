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

 Date: 27/12/2018 10:04:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `title` varchar(100) NOT NULL COMMENT '书名',
  `price` decimal(10,2) NOT NULL COMMENT '单价',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `disabled` bit(1) NOT NULL COMMENT '是否下架',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
