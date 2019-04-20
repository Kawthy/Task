/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50554
Source Host           : localhost:3306
Source Database       : user

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2018-04-15 14:00:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '1', '1', '1');
INSERT INTO `tb_user` VALUES ('2', '2', '2', '2');
INSERT INTO `tb_user` VALUES ('3', '3', '3', '3');
INSERT INTO `tb_user` VALUES ('4', '4', '4', '4');
INSERT INTO `tb_user` VALUES ('5', '5', '5', '5');
INSERT INTO `tb_user` VALUES ('6', '6', '6', '6');
INSERT INTO `tb_user` VALUES ('7', '7', '7', '7');
INSERT INTO `tb_user` VALUES ('8', '8', '8', '8');
INSERT INTO `tb_user` VALUES ('9', '9', '9', '9');
INSERT INTO `tb_user` VALUES ('10', '10', '10', '10');
