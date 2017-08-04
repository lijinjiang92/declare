/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : declare

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2017-04-20 17:50:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dd_wz
-- ----------------------------
DROP TABLE IF EXISTS `dd_wz`;
CREATE TABLE `dd_wz` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `Wz_Type` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of dd_wz
-- ----------------------------

-- ----------------------------
-- Table structure for dd_year
-- ----------------------------
DROP TABLE IF EXISTS `dd_year`;
CREATE TABLE `dd_year` (
  `Finance_ID` int(5) NOT NULL,
  `Finace_Year` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Finance_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of dd_year
-- ----------------------------

-- ----------------------------
-- Table structure for enterprise
-- ----------------------------
DROP TABLE IF EXISTS `enterprise`;
CREATE TABLE `enterprise` (
  `registration_No` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `credit_Code` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `enterprise_Name` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `legal_Representative` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `establishment_Date` date NOT NULL,
  `enterprise_Status` char(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registration_Institution` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `jurisdiction_Unit` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `enterprise_Type` int(5) NOT NULL,
  `registered_Capital` int(5) NOT NULL,
  `approval_Time` date DEFAULT NULL,
  `file_No` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `corporate_Industry` int(5) DEFAULT NULL,
  `business_Scope` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `term_Validity` date DEFAULT NULL,
  `address` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telphone` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `business_Licence` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `verifiy_Status` char(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`registration_No`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of enterprise
-- ----------------------------

-- ----------------------------
-- Table structure for enterprise_info
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_info`;
CREATE TABLE `enterprise_info` (
  `file_No` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `credit_Code` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `enterprise_Net` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `foreign_Capital` double(5,2) NOT NULL,
  `workers` int(5) NOT NULL,
  `level_Credit` int(5) DEFAULT NULL,
  `Occupy` double(5,2) DEFAULT NULL,
  `Info_Dept_People` int(5) DEFAULT NULL,
  `Computers` int(5) NOT NULL,
  `NetComputers` int(5) NOT NULL,
  `Broad_Ban` int(11) DEFAULT NULL,
  `Superintendent` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Super_Dept` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Super_Tel` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Super_Mobile` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Super_Email` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Finance` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Finance_Dept` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Finance_Tel` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Finance_Mobile` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Finance_Email` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Human` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Human_Dept` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Human_Tel` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Human_Mobile` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Human_Email` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Apply_Subject` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Work_System` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Awards` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`file_No`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of enterprise_info
-- ----------------------------

-- ----------------------------
-- Table structure for enterprise_report
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_report`;
CREATE TABLE `enterprise_report` (
  `file_No` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `credit_Code` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `FINANCE_YEAR` int(5) DEFAULT NULL,
  `sales` double(5,2) DEFAULT NULL,
  `profits` double(5,2) DEFAULT NULL,
  `taxs` double(5,2) DEFAULT NULL,
  `prod_Inputs_Hard` double(5,2) DEFAULT NULL,
  `prod_Inputs_Soft` double(5,2) DEFAULT NULL,
  PRIMARY KEY (`file_No`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of enterprise_report
-- ----------------------------

-- ----------------------------
-- Table structure for enterprise_sales
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_sales`;
CREATE TABLE `enterprise_sales` (
  `file_No` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `credit_Code` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `info_Type` char(1) COLLATE utf8_unicode_ci NOT NULL,
  `products_Name` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `prod_Sales` double(5,2) DEFAULT NULL,
  `customer_Area` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customers` int(5) DEFAULT NULL,
  PRIMARY KEY (`file_No`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of enterprise_sales
-- ----------------------------

-- ----------------------------
-- Table structure for interface
-- ----------------------------
DROP TABLE IF EXISTS `interface`;
CREATE TABLE `interface` (
  `id` int(5) NOT NULL,
  `API_Address` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `API_Keyword` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `API_date` date DEFAULT NULL,
  `API_status` char(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of interface
-- ----------------------------

-- ----------------------------
-- Table structure for mail
-- ----------------------------
DROP TABLE IF EXISTS `mail`;
CREATE TABLE `mail` (
  `id` int(5) NOT NULL,
  `SMTP` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `username` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `port` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of mail
-- ----------------------------

-- ----------------------------
-- Table structure for project_wz
-- ----------------------------
DROP TABLE IF EXISTS `project_wz`;
CREATE TABLE `project_wz` (
  `Subject_No` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `Wz_Type` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `Wz_Content` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Wz_Sum` int(5) DEFAULT NULL,
  `Wz_PayDate` date DEFAULT NULL,
  `Wz_Money` double(5,2) DEFAULT NULL,
  `Wz_Finance_No` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Wz_Bill_No` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Wz_Bill` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Subject_No`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of project_wz
-- ----------------------------

-- ----------------------------
-- Table structure for register
-- ----------------------------
DROP TABLE IF EXISTS `register`;
CREATE TABLE `register` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `registeName` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `registePassword` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creditCode` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telphone` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mobile` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `QQ` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `resume` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `HASH` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `registeredIP` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `lastLoginIP` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastLoginTime` datetime DEFAULT NULL,
  `userStatus` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of register
-- ----------------------------
INSERT INTO `register` VALUES ('a15b7', '张三', '7VPs-9HxmLlcUGsz32DN3A', null, null, '18761582251', null, null, null, '1000001966321253', '0:0:0:0:0:0:0:1', null, null, '0');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(5) NOT NULL,
  `role_Name` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `role_grant` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for role_grant
-- ----------------------------
DROP TABLE IF EXISTS `role_grant`;
CREATE TABLE `role_grant` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `grant_name` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `grant_flag` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of role_grant
-- ----------------------------

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `Subject_No` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `Credit_Code` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `Subject_Name` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `Registered_Service` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Service_Provider` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Declaration_Opinion` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Declaration_Time` date DEFAULT NULL,
  `Department_Opinion` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Department_Date` date DEFAULT NULL,
  `Subject_Start_Time` date DEFAULT NULL,
  `Subject_End_Time` date DEFAULT NULL,
  `Book_Person` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Examine_Person` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Subject_Upload` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Subject_Money` double DEFAULT NULL,
  PRIMARY KEY (`Subject_No`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of subject
-- ----------------------------

-- ----------------------------
-- Table structure for system_generator
-- ----------------------------
DROP TABLE IF EXISTS `system_generator`;
CREATE TABLE `system_generator` (
  `generatorType` varchar(32) NOT NULL COMMENT '类型 - 主键生成器类型',
  `initialVal` varchar(32) NOT NULL COMMENT '初始值',
  `currentVal` varchar(32) NOT NULL COMMENT '当前值',
  `maxVal` varchar(32) DEFAULT NULL COMMENT '最大值',
  `fetchSize` int(9) NOT NULL COMMENT '批次容量 - 每批获取的数目大小',
  `increment` int(9) NOT NULL COMMENT '增长值 - 每次增加多少',
  `isCycle` int(1) NOT NULL COMMENT '是否循环 - 值是否循环累加',
  `creatorId` varchar(32) NOT NULL COMMENT '创建人ID',
  `creator` varchar(32) NOT NULL COMMENT '创建人',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `modifierId` varchar(32) NOT NULL COMMENT '修改人ID',
  `modifier` varchar(32) NOT NULL COMMENT '修改人',
  `modifyTime` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`generatorType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='主键生成器 - 主键生成器';

-- ----------------------------
-- Records of system_generator
-- ----------------------------

-- ----------------------------
-- Table structure for sys_generator
-- ----------------------------
DROP TABLE IF EXISTS `sys_generator`;
CREATE TABLE `sys_generator` (
  `generatorType` varchar(32) NOT NULL COMMENT '类型 - 主键生成器类型',
  `initialVal` varchar(32) NOT NULL COMMENT '初始值',
  `currentVal` varchar(32) NOT NULL COMMENT '当前值',
  `maxVal` varchar(32) DEFAULT NULL COMMENT '最大值',
  `fetchSize` int(9) NOT NULL COMMENT '批次容量 - 每批获取的数目大小',
  `increment` int(9) NOT NULL COMMENT '增长值 - 每次增加多少',
  `isCycle` int(1) NOT NULL COMMENT '是否循环 - 值是否循环累加',
  `creatorId` varchar(32) NOT NULL COMMENT '创建人ID',
  `creator` varchar(32) NOT NULL COMMENT '创建人',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `modifierId` varchar(32) NOT NULL COMMENT '修改人ID',
  `modifier` varchar(32) NOT NULL COMMENT '修改人',
  `modifyTime` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`generatorType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='主键生成器 - 主键生成器';

-- ----------------------------
-- Records of sys_generator
-- ----------------------------
INSERT INTO `sys_generator` VALUES ('activity_id', 'a15b6', 'a19jy', null, '500', '1', '0', 'a162y', '管理员', '2016-05-05 15:43:43', 'a162y', '管理员', '2016-05-26 13:43:18');
INSERT INTO `sys_generator` VALUES ('bbs_section_ctg_id', '359', '2859', '2147483647', '500', '1', '0', 'a162y', '管理员', '2016-03-03 14:42:17', 'a162y', '管理员', '2016-03-09 16:18:59');
INSERT INTO `sys_generator` VALUES ('bbs_section_id', '359', '4359', '2147483647', '500', '1', '0', 'a162y', '管理员', '2016-03-04 16:08:52', 'a162y', '管理员', '2016-03-09 16:20:08');
INSERT INTO `sys_generator` VALUES ('bbs_topic_ctg_id', '359', '1859', '2147483647', '500', '1', '0', 'a162y', '管理员', '2016-03-09 08:42:23', 'a162y', '管理员', '2016-03-09 10:52:58');
INSERT INTO `sys_generator` VALUES ('bbs_topic_id', 'a15b6', 'a1abq', null, '500', '1', '0', '0', '系统', '2016-03-08 16:50:46', '0', '系统', '2016-03-09 14:56:13');
INSERT INTO `sys_generator` VALUES ('bbs_topic_reply_id', 'a15b6', 'a16gu', null, '500', '1', '0', '0', '系统', '2016-03-09 13:22:48', '0', '系统', '2016-03-09 14:13:14');
INSERT INTO `sys_generator` VALUES ('case_id', 'a15b6', 'a19jy', null, '500', '1', '0', 'a162y', '管理员', '2016-05-06 10:15:03', 'a162y', '管理员', '2016-05-24 17:12:11');
INSERT INTO `sys_generator` VALUES ('category_id', 'a15b6', 'a162y', null, '500', '1', '0', 'a162y', '管理员', '2017-04-11 10:11:00', 'a162y', '管理员', '2017-04-11 13:34:06');
INSERT INTO `sys_generator` VALUES ('company_id', 'a15b6', 'a180e', null, '500', '1', '0', '0', '系统', '2017-04-13 16:05:26', '0', '系统', '2017-04-18 13:22:46');
INSERT INTO `sys_generator` VALUES ('CONTACT_id', 'a15b6', 'a162y', null, '500', '1', '0', '0', '系统', '2017-04-10 15:05:40', '0', '系统', '2017-04-10 15:12:33');
INSERT INTO `sys_generator` VALUES ('delivery_addr_id', '10059', '18559', '9223372036854775807', '500', '1', '0', 'a1frn', '11', '2016-05-19 09:54:53', 'a1kt7', '13812186820', '2017-04-18 10:09:14');
INSERT INTO `sys_generator` VALUES ('dev_board_apply_id', 'a15b6', 'a1q56', null, '500', '1', '0', '0', '系统', '2016-05-13 15:24:41', 'a162y', '管理员', '2017-04-13 14:43:39');
INSERT INTO `sys_generator` VALUES ('dev_board_base_id', 'a15b6', 'a162y', null, '500', '1', '0', 'a162y', '管理员', '2016-05-06 14:43:42', 'a162y', '管理员', '2016-05-10 10:29:26');
INSERT INTO `sys_generator` VALUES ('dev_board_pro_id', 'a15b6', 'a178m', null, '500', '1', '0', 'a162y', '管理员', '2016-05-09 09:46:20', 'a162y', '管理员', '2016-05-18 15:14:19');
INSERT INTO `sys_generator` VALUES ('dev_board_report_id', 'a15b6', 'a19jy', null, '500', '1', '0', 'a162y', '管理员', '2016-05-09 10:27:31', 'a1gi3', 'a1e6r', '2016-06-30 10:52:39');
INSERT INTO `sys_generator` VALUES ('news_id', 'a15b6', 'a19jy', null, '500', '1', '0', 'a162y', '管理员', '2016-05-05 13:16:37', 'a162y', '管理员', '2017-04-20 11:05:30');
INSERT INTO `sys_generator` VALUES ('notice_id', 'a15b6', 'a1962', null, '500', '1', '0', 'a162y', '管理员', '2016-03-02 14:54:13', 'a162y', '管理员', '2016-03-09 16:21:23');
INSERT INTO `sys_generator` VALUES ('order_id', 'a15b6', 'a1cn2', null, '500', '1', '0', '0', '系统', '2017-04-13 13:51:02', 'a162y', '管理员', '2017-04-20 16:25:45');
INSERT INTO `sys_generator` VALUES ('personal_id', 'a15b6', 'a16uq', null, '500', '1', '0', '0', '系统', '2017-04-13 16:15:31', 'a162y', '管理员', '2017-04-20 10:50:46');
INSERT INTO `sys_generator` VALUES ('products_id', 'a15b6', 'a1962', null, '500', '1', '0', 'a162y', '管理员', '2017-04-11 13:44:28', 'a162y', '管理员', '2017-04-14 16:33:15');
INSERT INTO `sys_generator` VALUES ('register_id', 'a15b6', 'a15p2', null, '500', '1', '0', '0', '系统', '2017-04-20 16:35:18', '0', '系统', '2017-04-20 16:35:18');
INSERT INTO `sys_generator` VALUES ('resource_id', 'a15b6', 'a17mi', null, '500', '1', '0', 'a162y', '管理员', '2016-05-06 15:45:36', 'a162y', '管理员', '2016-06-13 10:30:04');
INSERT INTO `sys_generator` VALUES ('resource_type_id', '359', '2359', '2147483647', '500', '1', '0', 'a162y', '管理员', '2016-05-06 13:49:05', 'a162y', '管理员', '2016-05-10 10:13:57');
INSERT INTO `sys_generator` VALUES ('sd_id', 'a15b6', 'a178m', null, '500', '1', '0', 'a1kt7', '13812186820', '2017-04-17 16:57:26', 'a1kt7', '13812186820', '2017-04-18 14:40:41');
INSERT INTO `sys_generator` VALUES ('trade_order_id', 'a15b6', 'a1d0y', null, '500', '1', '0', 'a1iu3', 'ic管理员', '2016-09-01 11:31:27', 'a162y', '管理员', '2016-09-06 11:27:40');
INSERT INTO `sys_generator` VALUES ('trade_pro_type', 'a15b6', 'a162y', null, '500', '1', '0', 'a1iu3', 'ic管理员', '2016-09-01 16:44:39', 'a1iu3', 'ic管理员', '2016-09-02 10:11:04');
INSERT INTO `sys_generator` VALUES ('usual_issue_id', 'a15b6', 'a178m', null, '500', '1', '0', 'a162y', '管理员', '2016-05-06 11:07:29', 'a162y', '管理员', '2016-05-10 16:29:22');
INSERT INTO `sys_generator` VALUES ('usual_issue_type_id', '359', '1859', '2147483647', '500', '1', '0', 'a162y', '管理员', '2016-05-05 14:38:33', 'a162y', '管理员', '2016-05-10 16:27:13');
