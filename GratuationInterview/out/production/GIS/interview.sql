/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : interview

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2018-12-06 20:54:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `engque`
-- ----------------------------
DROP TABLE IF EXISTS `engque`;
CREATE TABLE `engque` (
  `E_No` char(9) CHARACTER SET gbk NOT NULL DEFAULT '',
  `E_content` char(100) CHARACTER SET gbk DEFAULT NULL,
  `E_level` char(2) CHARACTER SET gbk DEFAULT NULL,
  `E_flag` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`E_No`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of engque
-- ----------------------------
INSERT INTO `engque` VALUES ('1', '中国', '1', '0');
INSERT INTO `engque` VALUES ('2', 'ksjd', '难', '2');

-- ----------------------------
-- Table structure for `log`
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `login` varchar(11) CHARACTER SET gbk DEFAULT NULL,
  `password` char(8) CHARACTER SET gbk DEFAULT NULL,
  `time` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of log
-- ----------------------------

-- ----------------------------
-- Table structure for `majque`
-- ----------------------------
DROP TABLE IF EXISTS `majque`;
CREATE TABLE `majque` (
  `M_No` char(9) CHARACTER SET gbk NOT NULL DEFAULT '',
  `M_content` char(100) CHARACTER SET gbk DEFAULT NULL,
  `M_level` char(2) CHARACTER SET gbk DEFAULT NULL,
  `M_Major` char(10) CHARACTER SET gbk DEFAULT NULL,
  `M_flag` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`M_No`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of majque
-- ----------------------------

-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `M_manID` char(2) CHARACTER SET gbk NOT NULL DEFAULT '',
  `M_password` char(8) CHARACTER SET gbk DEFAULT NULL,
  PRIMARY KEY (`M_manID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('10', '88888888');
INSERT INTO `manager` VALUES ('56', '12345678');

-- ----------------------------
-- Table structure for `password`
-- ----------------------------
DROP TABLE IF EXISTS `password`;
CREATE TABLE `password` (
  `ID` varchar(11) NOT NULL,
  `password` char(8) DEFAULT NULL,
  `type` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of password
-- ----------------------------
INSERT INTO `password` VALUES ('12', '88888888', '???');
INSERT INTO `password` VALUES ('20', '88888888', '???');
INSERT INTO `password` VALUES ('20161414623', '88888888', '??');
INSERT INTO `password` VALUES ('24', '88', '???');
INSERT INTO `password` VALUES ('56', '12345678', '???');

-- ----------------------------
-- Table structure for `polque`
-- ----------------------------
DROP TABLE IF EXISTS `polque`;
CREATE TABLE `polque` (
  `P_No` char(9) CHARACTER SET gbk NOT NULL DEFAULT '',
  `P_content` char(100) CHARACTER SET gbk DEFAULT NULL,
  `P_level` char(2) CHARACTER SET gbk DEFAULT NULL,
  `P_flag` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`P_No`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of polque
-- ----------------------------

-- ----------------------------
-- Table structure for `queno`
-- ----------------------------
DROP TABLE IF EXISTS `queno`;
CREATE TABLE `queno` (
  `S_stuID` char(11) CHARACTER SET gbk DEFAULT NULL,
  `majNo` smallint(6) DEFAULT NULL,
  `polNo` smallint(6) DEFAULT NULL,
  `EngNo` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of queno
-- ----------------------------

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `S_stuID` char(11) CHARACTER SET gbk NOT NULL DEFAULT '',
  `S_name` varchar(20) CHARACTER SET gbk NOT NULL,
  `S_polGrade` smallint(6) DEFAULT NULL,
  `S_EngGrade` smallint(6) DEFAULT NULL,
  `S_majGrade` smallint(6) DEFAULT NULL,
  `S_major` char(10) CHARACTER SET gbk NOT NULL,
  `S_intGrade` smallint(6) DEFAULT NULL,
  `S_School` varchar(20) CHARACTER SET gbk NOT NULL,
  `S_ID` char(18) CHARACTER SET gbk NOT NULL,
  `S_sex` char(1) CHARACTER SET gbk NOT NULL,
  `S_phone` char(11) CHARACTER SET gbk NOT NULL,
  `S_password` char(8) CHARACTER SET gbk DEFAULT NULL,
  `S_flag` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`S_stuID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('20161414623', 'dqy', '90', '90', '90', 'cs', '96', 'scu', '510264200005144956', 'f', '18324596542', '88888888', '1');
INSERT INTO `student` VALUES ('20161414624', '黄月瑶', '90', '89', '94', 'cs', '90', 'scu', '500159199807144953', 'f', '18388202156', null, '1');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `T_TeaID` char(6) CHARACTER SET gbk NOT NULL DEFAULT '',
  `T_name` varchar(20) CHARACTER SET gbk DEFAULT NULL,
  `T_major` char(10) CHARACTER SET gbk DEFAULT NULL,
  `T_password` char(8) CHARACTER SET gbk DEFAULT NULL,
  `T_flag` smallint(6) NOT NULL,
  PRIMARY KEY (`T_TeaID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('201614', 'dhs', 'cs', '12345678', '1');
INSERT INTO `teacher` VALUES ('201645', 'dsf', 'cs', null, '0');

-- ----------------------------
-- Table structure for `teavisiabel`
-- ----------------------------
DROP TABLE IF EXISTS `teavisiabel`;
CREATE TABLE `teavisiabel` (
  `S_stuID` char(11) CHARACTER SET gbk NOT NULL DEFAULT '',
  `S_name` varchar(20) CHARACTER SET gbk DEFAULT NULL,
  `S_polGrade` smallint(6) DEFAULT NULL,
  `S_EngGrade` smallint(6) DEFAULT NULL,
  `S_majGrade` smallint(6) DEFAULT NULL,
  `S_major` char(10) CHARACTER SET gbk DEFAULT NULL,
  PRIMARY KEY (`S_stuID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of teavisiabel
-- ----------------------------
