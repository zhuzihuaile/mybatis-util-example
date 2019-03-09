/*
Navicat MySQL Data Transfer

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-03-09 16:07:12
*/


-- ----------------------------
-- Table structure for `test`
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(24) DEFAULT NULL,
  `test_name` varchar(24) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', 'name', 'testName', '2018-10-01 10:00:00');
INSERT INTO `test` VALUES ('2', 'java', 'mybatis', '2018-10-02 10:00:00');
