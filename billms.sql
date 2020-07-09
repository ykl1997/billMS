/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50527
 Source Host           : localhost:3306
 Source Schema         : billms

 Target Server Type    : MySQL
 Target Server Version : 50527
 File Encoding         : 65001

 Date: 09/07/2020 16:21:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_balance_calculation
-- ----------------------------
DROP TABLE IF EXISTS `t_balance_calculation`;
CREATE TABLE `t_balance_calculation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `baseMoney` double(10, 2) DEFAULT NULL,
  `income` double(10, 2) DEFAULT NULL,
  `rent` double(10, 2) DEFAULT NULL,
  `hydropower` double(10, 2) DEFAULT NULL,
  `eating` double(10, 2) DEFAULT NULL,
  `dinner` double(10, 2) DEFAULT NULL,
  `ktv` double(10, 2) DEFAULT NULL,
  `balance` double(10, 2) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `pk2`(`userId`) USING BTREE,
  CONSTRAINT `pk2` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_bookkeeping
-- ----------------------------
DROP TABLE IF EXISTS `t_bookkeeping`;
CREATE TABLE `t_bookkeeping`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `money` double(10, 2) DEFAULT NULL,
  `income` double(10, 2) DEFAULT NULL,
  `rent` double(10, 2) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `pk4`(`userid`) USING BTREE,
  CONSTRAINT `pk4` FOREIGN KEY (`userid`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_manage_finances
-- ----------------------------
DROP TABLE IF EXISTS `t_manage_finances`;
CREATE TABLE `t_manage_finances`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `money` double(10, 2) DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `days` int(10) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `pk1`(`userId`) USING BTREE,
  CONSTRAINT `pk1` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_payment_installments
-- ----------------------------
DROP TABLE IF EXISTS `t_payment_installments`;
CREATE TABLE `t_payment_installments`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `money` double(10, 2) DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `installment` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `pk3`(`userid`) USING BTREE,
  CONSTRAINT `pk3` FOREIGN KEY (`userid`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
