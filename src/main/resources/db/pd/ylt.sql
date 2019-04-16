/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : ylt

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2019-04-15 22:44:06
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
INSERT INTO `hibernate_sequence` VALUES ('1');

-- ----------------------------
-- Table structure for rent_order
-- ----------------------------
DROP TABLE IF EXISTS `rent_order`;
CREATE TABLE `rent_order` (
  `ID` char(32) NOT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `CREATOR` char(32) DEFAULT NULL,
  `MODIFY_TIME` datetime DEFAULT NULL,
  `MODIFIER` char(32) DEFAULT NULL,
  `DELETE_TIME` datetime DEFAULT NULL,
  `DELETER` char(32) DEFAULT NULL,
  `IS_DELETE` varchar(2) DEFAULT NULL COMMENT '1：删除',
  `USER_ID` varchar(32) DEFAULT NULL,
  `VEHICLE_ID` varchar(32) DEFAULT NULL,
  `RENT` varchar(8) DEFAULT NULL,
  `COST_RENT` varchar(8) DEFAULT NULL,
  `OBTAIN_PROV` varchar(64) DEFAULT NULL,
  `OBTAIN_CITY` varchar(64) DEFAULT NULL,
  `OBTAIN_AREA` varchar(64) DEFAULT NULL,
  `RETURN_PROV` varchar(64) DEFAULT NULL,
  `RETURN_CITY` varchar(64) DEFAULT NULL,
  `RETURN_AREA` varchar(64) DEFAULT NULL,
  `ORDER_STATUS` varchar(32) DEFAULT NULL,
  `ORDER_NO` varchar(16) DEFAULT NULL,
  `OBTAIN_TIME` datetime DEFAULT NULL,
  `RETURN_TIME` datetime DEFAULT NULL,
  `OBTAIN_SHOP` varchar(64) DEFAULT NULL,
  `RETURN_SHOP` varchar(64) DEFAULT NULL,
  `FINISH_TIME` datetime DEFAULT NULL,
  `DURATION` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单';

-- ----------------------------
-- Records of rent_order
-- ----------------------------
INSERT INTO `rent_order` VALUES ('41457911a5564237b52557fa1ed836a6', '2019-04-15 13:57:57', 'cff71855a49549adac1379a3e46b26e5', null, null, null, null, null, 'cff71855a49549adac1379a3e46b26e5', '6836d60cfe08454dbf92d2624bfd5388', '105', '265230', '北京市', '北京市', '东城区', '北京市', '北京市', '东城区', '未支付', '201904150003', '2019-04-15 13:57:00', '2012-05-15 17:05:00', '高铁站店', '高铁站店', null, '2526');
INSERT INTO `rent_order` VALUES ('d9c3e61eddeb4ee49a0b2c697906c0e4', '2019-04-15 13:55:29', 'cff71855a49549adac1379a3e46b26e5', null, null, null, null, null, 'cff71855a49549adac1379a3e46b26e5', '6836d60cfe08454dbf92d2624bfd5388', '105', '265230', '北京市', '北京市', '东城区', '北京市', '北京市', '东城区', '未支付', '2019-04-150002', '2019-04-15 13:55:00', '2012-05-15 16:00:00', '高铁站店', '高铁站店', null, '2526');

-- ----------------------------
-- Table structure for serial_number
-- ----------------------------
DROP TABLE IF EXISTS `serial_number`;
CREATE TABLE `serial_number` (
  `ID` char(32) NOT NULL,
  `SERIAL_NAME` varchar(16) DEFAULT NULL,
  `SERIAL_NO` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流水号';

-- ----------------------------
-- Records of serial_number
-- ----------------------------
INSERT INTO `serial_number` VALUES ('1', 'orderNo', '4');

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `delete_time` datetime DEFAULT NULL,
  `deleter` varchar(255) DEFAULT NULL,
  `is_delete` varchar(255) DEFAULT NULL,
  `modifier` varchar(255) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `prov` varchar(255) DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('73968386cb7f45e79af83e0539da284e', '2019-04-12 13:59:50', '9dd82f8709e2411a9f196defd9f2fbe0', null, null, null, null, null, '', '东城区', '北京市', '北京市', '高铁站店');
INSERT INTO `shop` VALUES ('a357db50455b4692925fb9350fa1b9b2', '2019-04-12 14:13:43', '9dd82f8709e2411a9f196defd9f2fbe0', null, null, null, null, null, '', '西城区', '北京市', '北京市', '西城店');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` char(32) NOT NULL,
  `USERNAME` varchar(16) DEFAULT NULL,
  `PASSWORD` varchar(16) DEFAULT NULL,
  `NAME` varchar(16) DEFAULT NULL,
  `SEX` varchar(2) DEFAULT NULL COMMENT '1：男；2：女',
  `AGE` varchar(16) DEFAULT NULL,
  `BIRTHDAY` datetime DEFAULT NULL,
  `PHONE` varchar(16) DEFAULT NULL,
  `MAIL` varchar(32) DEFAULT NULL,
  `ADDRESS` varchar(64) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `CREATOR` char(32) DEFAULT NULL,
  `MODIFY_TIME` datetime DEFAULT NULL,
  `MODIFIER` char(32) DEFAULT NULL,
  `DELETE_TIME` datetime DEFAULT NULL,
  `DELETER` char(32) DEFAULT NULL,
  `IS_DELETE` varchar(2) DEFAULT NULL COMMENT '1：删除',
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('048fdf2e16554ee1b9bbb4b74ee68017', 'a33333333333333', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:13:54', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('0b3540a9068a48d5b205b9ec66e4e5dc', 'a333333', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:13:41', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('12793abc371441dba099340374caf3bc', 'a111111', 'MTExMTEx', '而沙溪', '1', null, '2019-03-30 16:00:00', '18622909511', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:12:46', null, '2019-03-23 15:17:42', '9dd82f8709e2411a9f196defd9f2fbe0', null, null, null, '2');
INSERT INTO `user` VALUES ('13b3480ad91042779e5d4f5071690bf0', 'a3333333333', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:13:48', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('1440005b9c4d4416a0f7e47274fdef28', 'aaaa', 'MTExMTEx', null, null, null, null, null, 'xieyiyue1991@163.com', null, '2019-04-10 15:13:09', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('14c3187b096a4b3bb49c8978e50c4dcd', 'aaaa', 'MTExMTEx', null, null, null, null, null, 'xieyiyue1991@163.com', null, '2019-04-10 15:13:09', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('2a2cdc45d5564c4bb9f3054fc80b53dc', 'a122222222222', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:13:28', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('3075f0ac27f14bec9dbd5056319e305b', 'a12222222', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:13:21', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('3379aede79b048a1b83a5de361ecb68c', 'a111111111111111', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:13:01', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('3abd303d080e407cbe6c154b1d22cbc3', 'a333333333333333', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:13:55', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('3c8a605979d84efd8f3a413cef35b756', 'a1111111', 'MTExMTEx', '谢溢戈', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:12:47', null, '2019-03-23 15:19:19', '9dd82f8709e2411a9f196defd9f2fbe0', null, null, null, '2');
INSERT INTO `user` VALUES ('3f55404b7f774f71b29894876904b82a', 'a1222222222', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:13:24', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('444b622bc1914d85b790ec94ec989320', 'a122222', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:13:18', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('46de0c373e1741a486d45c9f2eadff84', 'aaaaa', 'MTExMTEx', null, null, null, null, null, 'xieyiyue1991@163.com', null, '2019-04-10 15:25:44', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('4bff74f1371944af857557fcc6e4f966', 'a333333333333', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:13:51', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('5d3f041d77124784b0e8a40acf1b5f22', 'a11111', 'MTIzNDU2', '大傻子', '2', null, '2019-03-03 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:12:43', null, '2019-03-24 00:59:40', '9dd82f8709e2411a9f196defd9f2fbe0', null, null, null, '2');
INSERT INTO `user` VALUES ('604e98f62a434ac987a13aef3bab4c67', 'a33333333', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:13:44', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('66d8935f995b45a8887ec5de56469275', 'a3333333', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:13:43', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('6716ebe60b7b445fb27db15bceb60202', 'a11111111', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:12:49', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('692c2218c3864501b0f065600689e2eb', 'a3333333333333', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:13:52', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('6cab53ad83fb4300bf25033f3a6a534c', 'a11111111111111', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:12:59', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('71972a7cb5cb4a549140884443a103f6', 'a111111111', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:12:51', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('792b4b8ec2c74e93adbc6c9292425991', 'a12222', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:13:16', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('795bae597bff4f3391ea31287da8c2e1', 'a1111', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:12:42', null, null, null, '2019-03-23 01:13:16', '9dd82f8709e2411a9f196defd9f2fbe0', '1', '2');
INSERT INTO `user` VALUES ('8573cbcb20a040c2a8966f54729042d3', 'a33333', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:13:40', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('8860d97dfa804923a7bd2c5c027f559c', 'a12222222222', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:13:26', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('8b86f1eac43c400b8a3ea792a619ce05', 'a33333333333', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:13:49', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('8bde027db2f247198cea37dbaa1fb46a', 'a1111111111', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:12:52', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('9789aec83113448996b948b08819da9a', 'a122', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:13:13', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('9dd82f8709e2411a9f196defd9f2fbe0', 'admin', 'MTExMTEx', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1');
INSERT INTO `user` VALUES ('a540ef930e624de1aee35bd139602ece', 'a333', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:13:36', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('a6ed38c7a69d4d71842724acd92fe36f', 'a1111111111111', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:12:58', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('a7f50c7e62044b6aa8599652570f5e82', 'a3333', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:13:38', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('adcedb1cc11d4a28b085580e4526778c', 'a111', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:12:37', null, null, null, '2019-03-23 01:10:36', '9dd82f8709e2411a9f196defd9f2fbe0', '1', '2');
INSERT INTO `user` VALUES ('badc904960f04bfabdcc16b67fe03e5e', 'a11111111111', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:12:54', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('bf52cd0b4e634848a9bc43b99151e2da', 'a1222222222222', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:13:29', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('c8984d8aadbd48e6810118adb4731b9d', 'a12222222222222', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:13:31', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('cfb4a5908fac48b1bc8e47638d894ca6', 'a111111111111', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:12:56', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('cff71855a49549adac1379a3e46b26e5', 'qwerty', 'MTExMTEx', null, null, null, null, null, 'xieyiyue1991@163.com', null, '2019-04-02 15:22:00', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('d8c41871e9b543d1897b1c65674240ea', 'a1222222', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:13:19', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('e1afb76d77ad4268b56f4d3fe6e483fd', 'a1222', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:13:15', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('e3e8171e916145d7a604d3fb6927eea5', 'a333333333', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:13:46', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('f8d2eccdf9c34aafbbcc4d309bbc6d64', 'aaaa', 'MTExMTEx', null, null, null, null, null, 'xieyiyue1991@163.com', null, '2019-04-10 15:13:09', null, null, null, null, null, null, '2');
INSERT INTO `user` VALUES ('fa752743db75419f8d6cff4e9770cd4e', 'a122222222', 'MTExMTEx', 'yiyue xie', '1', null, '2019-02-28 16:00:00', '18622909550', 'xieyiyue1991@163.com', '21A Bellecor Drive MANOR', '2019-03-22 12:13:23', null, null, null, null, null, null, '2');

-- ----------------------------
-- Table structure for vehicle
-- ----------------------------
DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE `vehicle` (
  `ID` char(32) DEFAULT NULL,
  `LICENSE` varchar(16) DEFAULT NULL,
  `BRAND` varchar(32) DEFAULT NULL,
  `MODEL` varchar(32) DEFAULT NULL,
  `SEAT_NUM` varchar(2) DEFAULT NULL,
  `COLOUR` varchar(16) DEFAULT NULL,
  `VIN` varchar(32) DEFAULT NULL,
  `FIRST_LICENSE` datetime DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `CREATOR` char(32) DEFAULT NULL,
  `MODIFY_TIME` datetime DEFAULT NULL,
  `MODIFIER` char(32) DEFAULT NULL,
  `DELETE_TIME` datetime DEFAULT NULL,
  `DELETER` char(32) DEFAULT NULL,
  `IS_DELETE` varchar(2) DEFAULT NULL COMMENT '1：删除',
  `RENT` varchar(8) DEFAULT NULL,
  `IS_STOP` varchar(2) DEFAULT NULL COMMENT '0：启用；1：停用',
  `CUBICLES` varchar(8) DEFAULT NULL,
  `EXHAUST` varchar(32) DEFAULT NULL,
  `IMG_PATH` varchar(256) DEFAULT NULL,
  `TYPE` varchar(8) DEFAULT NULL COMMENT '1:普通；2：豪华'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆表';

-- ----------------------------
-- Records of vehicle
-- ----------------------------
INSERT INTO `vehicle` VALUES ('6836d60cfe08454dbf92d2624bfd5388', '津A12345', '雪佛兰', '科迈罗', '4', 'yellow', '123456789', '2019-04-07 16:00:00', '2019-04-08 14:57:50', '9dd82f8709e2411a9f196defd9f2fbe0', '2019-04-11 14:32:37', '9dd82f8709e2411a9f196defd9f2fbe0', null, null, null, '105', '0', '3.7自然进气', '三', '1554993155898car1.png', '轿车');
INSERT INTO `vehicle` VALUES ('98b060352d9040c9b05dd1408481ade9', '津A12345', '宝马', '525li', '7', '白', '12344556', '2019-04-22 16:00:00', '2019-04-09 12:51:31', '9dd82f8709e2411a9f196defd9f2fbe0', '2019-04-11 14:32:44', '9dd82f8709e2411a9f196defd9f2fbe0', null, null, null, '800', null, '4.8双机械增压', '三', '1554993162989car2.png', 'MPV');
