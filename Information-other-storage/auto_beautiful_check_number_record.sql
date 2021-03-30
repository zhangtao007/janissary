/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : janissary_set

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 09/11/2019 13:37:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auto_beautiful_check_number_record
-- ----------------------------
DROP TABLE IF EXISTS `auto_beautiful_check_number_record`;
CREATE TABLE `auto_beautiful_check_number_record`  (
  `record_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ten_million` int(10) NOT NULL,
  `one_million` int(10) NOT NULL,
  `one_hundred_thousand` int(10) NOT NULL,
  `ten_thousand` int(10) NOT NULL,
  `one_thousand` int(10) NOT NULL,
  PRIMARY KEY (`record_type`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auto_beautiful_check_number_record
-- ----------------------------
INSERT INTO `auto_beautiful_check_number_record` VALUES ('GUEST_FRIEND', 7, 0, 0, 1, 1);
INSERT INTO `auto_beautiful_check_number_record` VALUES ('GUEST_GROUP', 7, 0, 0, 1, 1);
INSERT INTO `auto_beautiful_check_number_record` VALUES ('GUEST_GROUP_MEMBER', 7, 0, 0, 1, 1);
INSERT INTO `auto_beautiful_check_number_record` VALUES ('REGISTERED_FRIEND', 1, 0, 0, 1, 1);
INSERT INTO `auto_beautiful_check_number_record` VALUES ('REGISTERED_GROUP', 1, 0, 0, 1, 1);
INSERT INTO `auto_beautiful_check_number_record` VALUES ('REGISTERED_GROUP_MEMBER', 1, 0, 0, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
