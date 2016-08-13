/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50624
Source Host           : 127.0.0.1:3306
Source Database       : deer

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-08-05 23:51:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for children
-- ----------------------------
DROP TABLE IF EXISTS `children`;
CREATE TABLE `children` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime NOT NULL,
  `modify_date` datetime NOT NULL,
  `age` int(255) DEFAULT NULL,
  `gender` bit(11) DEFAULT NULL,
  `chinese_name` varchar(255) DEFAULT NULL,
  `english_name` varchar(255) DEFAULT NULL,
  `member_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of children
-- ----------------------------
INSERT INTO `children` VALUES ('5', '2016-07-16 18:41:00', '2016-07-16 18:41:00', null, null, 'andy', null, '20');
INSERT INTO `children` VALUES ('6', '2016-07-16 18:41:28', '2016-07-16 18:41:28', null, null, 'ww', null, '21');
INSERT INTO `children` VALUES ('7', '2016-07-16 22:47:52', '2016-07-16 22:47:52', null, null, 'sss', null, '22');
INSERT INTO `children` VALUES ('8', '2016-07-17 00:20:40', '2016-07-17 00:20:40', null, null, 'dddd', null, '23');
INSERT INTO `children` VALUES ('9', '2016-07-17 00:34:10', '2016-07-17 00:34:10', null, null, '1111', null, '24');
INSERT INTO `children` VALUES ('10', '2016-07-17 18:29:05', '2016-07-17 18:29:05', null, null, 'ddd', null, '25');
INSERT INTO `children` VALUES ('11', '2016-07-17 20:07:28', '2016-07-17 20:07:28', null, null, '22222', null, '26');
INSERT INTO `children` VALUES ('12', '2016-07-17 21:27:22', '2016-07-17 21:27:22', null, null, 'ccc', null, '27');
INSERT INTO `children` VALUES ('13', '2016-07-17 21:35:01', '2016-07-17 21:35:01', null, null, '138685800002', null, '28');
INSERT INTO `children` VALUES ('14', '2016-07-18 23:06:25', '2016-07-18 23:06:25', null, null, 'eee', null, '29');
INSERT INTO `children` VALUES ('15', '2016-07-18 23:09:47', '2016-07-18 23:09:47', null, null, 'dddd', null, '30');
INSERT INTO `children` VALUES ('16', '2016-07-18 23:10:13', '2016-07-18 23:10:13', null, null, 'xxx', null, '31');
INSERT INTO `children` VALUES ('17', '2016-07-18 23:10:32', '2016-07-18 23:10:32', null, null, '2222', null, '32');
INSERT INTO `children` VALUES ('18', '2016-07-18 23:10:55', '2016-07-18 23:10:55', null, null, '15158067701', null, '33');
INSERT INTO `children` VALUES ('19', '2016-07-18 23:11:13', '2016-07-18 23:11:13', null, null, '15158067702', null, '34');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` varchar(32) NOT NULL,
  `create_date` datetime NOT NULL,
  `modify_date` datetime NOT NULL,
  `content` longtext,
  `ip` varchar(255) NOT NULL,
  `operation` varchar(255) NOT NULL,
  `operator` varchar(255) DEFAULT NULL,
  `parameter` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime NOT NULL,
  `modify_date` datetime NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `is_enabled` bit(1) NOT NULL,
  `is_locked` bit(1) NOT NULL,
  `login_failure_count` int(11) NOT NULL,
  `locked_date` datetime DEFAULT NULL,
  `register_ip` varchar(255) NOT NULL,
  `login_ip` varchar(255) DEFAULT NULL,
  `login_date` datetime DEFAULT NULL,
  `recommender` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('20', '2016-07-16 18:41:00', '2016-07-16 18:41:00', '13876589054', 'b87fb9754977e80e4ca630076259d077', null, null, '', '\0', '0', null, '0:0:0:0:0:0:0:1', '0:0:0:0:0:0:0:1', '2016-07-16 18:41:01', null);
INSERT INTO `member` VALUES ('21', '2016-07-16 18:41:28', '2016-07-16 22:47:22', '13868765432', 'b87fb9754977e80e4ca630076259d077', null, null, '', '\0', '0', null, '0:0:0:0:0:0:0:1', '0:0:0:0:0:0:0:1', '2016-07-16 22:47:23', null);
INSERT INTO `member` VALUES ('22', '2016-07-16 22:47:52', '2016-07-16 22:53:46', '13868765435', '96aa4294625fa8518a54138bae78be69', null, null, '', '\0', '0', null, '0:0:0:0:0:0:0:1', '0:0:0:0:0:0:0:1', '2016-07-16 22:53:47', null);
INSERT INTO `member` VALUES ('23', '2016-07-17 00:20:40', '2016-07-17 00:20:40', '13868765422', 'a151130815a37bb53add19bb23cbb99f', null, null, '', '\0', '0', null, '0:0:0:0:0:0:0:1', '0:0:0:0:0:0:0:1', '2016-07-17 00:20:41', null);
INSERT INTO `member` VALUES ('24', '2016-07-17 00:34:10', '2016-07-17 00:34:10', '13867872222', 'b4ce023e427cd5cfa1cf6435208ef139', null, null, '', '\0', '0', null, '127.0.0.1', '127.0.0.1', '2016-07-17 00:34:10', null);
INSERT INTO `member` VALUES ('25', '2016-07-17 18:29:05', '2016-07-17 18:29:05', '13868587123', '175617b7a6e353e91bb2953686eaa145', null, null, '', '\0', '0', null, '0:0:0:0:0:0:0:1', '0:0:0:0:0:0:0:1', '2016-07-17 18:29:05', null);
INSERT INTO `member` VALUES ('26', '2016-07-17 20:07:28', '2016-07-17 20:07:28', '13868567898', '5df2b99a9d25319fefa52dd7fa36b990', null, null, '', '\0', '0', null, '0:0:0:0:0:0:0:1', '0:0:0:0:0:0:0:1', '2016-07-17 20:07:28', null);
INSERT INTO `member` VALUES ('27', '2016-07-17 21:27:22', '2016-07-17 21:27:22', '13868580000', 'c3e66f7a7a7d1fffd5d277a76f51a04b', null, null, '', '\0', '0', null, '0:0:0:0:0:0:0:1', '0:0:0:0:0:0:0:1', '2016-07-17 21:27:23', null);
INSERT INTO `member` VALUES ('28', '2016-07-17 21:35:01', '2016-07-17 21:35:01', '13868580002', '348fe4cc11c0416b2f1e5802a6bee4d7', null, null, '', '\0', '0', null, '0:0:0:0:0:0:0:1', '0:0:0:0:0:0:0:1', '2016-07-17 21:35:01', '13868580002');
INSERT INTO `member` VALUES ('29', '2016-07-18 23:06:25', '2016-07-18 23:06:25', '13868581002', '5a9d98758b725c883a898d307f614cb8', null, null, '', '\0', '0', null, '0:0:0:0:0:0:0:1', '0:0:0:0:0:0:0:1', '2016-07-18 23:06:26', null);
INSERT INTO `member` VALUES ('30', '2016-07-18 23:09:47', '2016-07-18 23:09:47', '15158067786', '893ca4c5304235696a9426085248a97c', null, null, '', '\0', '0', null, '0:0:0:0:0:0:0:1', '0:0:0:0:0:0:0:1', '2016-07-18 23:09:47', '15158067786');
INSERT INTO `member` VALUES ('31', '2016-07-18 23:10:13', '2016-07-18 23:10:13', '15158067700', '7ede83e957a7fc7108baac67a992be12', null, null, '', '\0', '0', null, '0:0:0:0:0:0:0:1', '0:0:0:0:0:0:0:1', '2016-07-18 23:10:14', '15158067700');
INSERT INTO `member` VALUES ('32', '2016-07-18 23:10:32', '2016-07-18 23:10:32', '15158067701', '01ca93a4dc583d2df9726a7a011b48b0', null, null, '', '\0', '0', null, '0:0:0:0:0:0:0:1', '0:0:0:0:0:0:0:1', '2016-07-18 23:10:32', null);
INSERT INTO `member` VALUES ('33', '2016-07-18 23:10:55', '2016-07-18 23:10:55', '15158067702', '3e56cd936bd4262b40f2d97512a73e26', null, null, '', '\0', '0', null, '0:0:0:0:0:0:0:1', '0:0:0:0:0:0:0:1', '2016-07-18 23:10:55', null);
INSERT INTO `member` VALUES ('34', '2016-07-18 23:11:13', '2016-07-18 23:11:13', '15158067703', '3e56cd936bd4262b40f2d97512a73e26', null, null, '', '\0', '0', null, '0:0:0:0:0:0:0:1', '0:0:0:0:0:0:0:1', '2016-07-18 23:11:14', '15158067702');
