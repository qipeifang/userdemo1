/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : userdemo

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2020-04-27 18:40:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('10');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `grade` int(11) NOT NULL,
  `isvip` int(11) NOT NULL,
  `is_manager` int(11) NOT NULL,
  `grander` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=140 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'dj', '123', '2290912114@qq.com', '0', '0', '0', null);
INSERT INTO `t_user` VALUES ('2', 'user', '1', '123456789@qq.com', '0', '0', '0', null);
INSERT INTO `t_user` VALUES ('3', 'jnmkmkl', 'e462e2c76637831ed7aac2908abeb360e18f57e2', '123456789999999@qq.com', '0', '0', '0', null);
INSERT INTO `t_user` VALUES ('4', 'jxmxkmxkamkx', 'd21a64e9c5fc0eafe964e95fdd08ad1e8b39c423', 'njjnsxmksmxmskmakm@129.com', '0', '0', '0', null);
INSERT INTO `t_user` VALUES ('5', 'kmkmkm', '2ef7a853ecc2a71035c355fe0d0dfd1a5a49f81d', 'ksmxkmx@qq.com', '0', '0', '0', '1');
INSERT INTO `t_user` VALUES ('6', 'qpf', '356a192b7913b04c54574d18c28d46e6395428ab', '1@qq.com', '0', '0', '0', null);
INSERT INTO `t_user` VALUES ('7', 'mskmkm', '8aacc0d0b96d50a6e31f690a6f2be13f40f660e5', 'kmkmkkdwidjedsmxm@189.com', '0', '0', '0', null);
INSERT INTO `t_user` VALUES ('8', 'pt', '356a192b7913b04c54574d18c28d46e6395428ab', '1234@qq.com', '0', '0', '0', '0');
INSERT INTO `t_user` VALUES ('9', 'sjjidji', '9ccd62276bb79ac937e93d3694c7c6dce7c3e4d1', '98765@189.com', '0', '0', '0', '0');
INSERT INTO `t_user` VALUES ('11', 'hijiji', '2e4a4eb994a7672ebb24c555b1a69aa7c9abc1e1', 'wedwds@qq.com', '0', '0', '0', null);
INSERT INTO `t_user` VALUES ('12', 'dmkmckm', '42c5d7d164ffd7c8ff01a8e6b63c0c43382a3af9', 'kmsfdkm@qq.com', '0', '0', '0', '0');
INSERT INTO `t_user` VALUES ('13', 'dnvmxmc,', '40c43463128e0669d46b18e5f747921d2109b24f', 'dfmsml@qq.com', '0', '0', '0', null);
INSERT INTO `t_user` VALUES ('14', 'djsnckmc', '448b9854e64d42285f47c8cf66c09f2955b005be', 'ekfdkck@qq.com', '0', '0', '0', null);
INSERT INTO `t_user` VALUES ('15', 'fdnvcmxnm', 'a10e81ba815923fdb00f8992d5581e685573b627', 'dvdc@qq.com', '0', '0', '0', null);
INSERT INTO `t_user` VALUES ('16', 'fjdnjcn', '4a45672f3abd9c64d958e979e2ebfec2784c648e', 'fd@qq.com', '0', '0', '0', null);
