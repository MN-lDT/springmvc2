/*
Navicat MySQL Data Transfer

Source Server         : test01
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : springmvc1

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2018-07-30 11:49:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for d_user
-- ----------------------------
DROP TABLE IF EXISTS `d_user`;
CREATE TABLE `d_user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_age` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_user
-- ----------------------------
INSERT INTO `d_user` VALUES ('1', 'li', '22');
INSERT INTO `d_user` VALUES ('2', 'box', '13');
INSERT INTO `d_user` VALUES ('3', 'jack', '18');