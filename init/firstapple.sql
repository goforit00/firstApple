/*
 Navicat MySQL Data Transfer

 Source Server         : 本地环境
 Source Server Version : 50709
 Source Host           : localhost
 Source Database       : firstapple

 Target Server Version : 50709
 File Encoding         : utf-8

 Date: 06/29/2016 00:34:27 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `sequence`
-- ----------------------------
DROP TABLE IF EXISTS `sequence`;
CREATE TABLE `sequence` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `table_name` varchar(32) NOT NULL,
  `created_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `system_config`
-- ----------------------------
DROP TABLE IF EXISTS `system_config`;
CREATE TABLE `system_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key` varchar(32) NOT NULL,
  `value` varchar(1024) NOT NULL,
  `des` varchar(128) NOT NULL,
  `modified_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(20) NOT NULL,
  `username` varchar(64) NOT NULL,
  `password` varchar(128) NOT NULL,
  `phone` varchar(32) NOT NULL,
  `email` varchar(64) NOT NULL,
  `age` int(11) NOT NULL,
  `sex` varchar(8) NOT NULL,
  `real_name` varchar(64) NOT NULL,
  `status` varchar(32) NOT NULL,
  `last_login_time` datetime NOT NULL,
  `register_time` datetime NOT NULL,
  `modified_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_uq` (`username`),
  UNIQUE KEY `phone_uq` (`phone`),
  UNIQUE KEY `email_uq` (`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `user_administrator`
-- ----------------------------
DROP TABLE IF EXISTS `user_administrator`;
CREATE TABLE `user_administrator` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) NOT NULL,
  `auth_role_id` bigint(20) NOT NULL,
  `latest_login_time` datetime NOT NULL,
  `modified_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `user_customer`
-- ----------------------------
DROP TABLE IF EXISTS `user_customer`;
CREATE TABLE `user_customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) NOT NULL,
  `points` bigint(20) NOT NULL,
  `latest_login_time` datetime NOT NULL,
  `modified_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `user_operation_token`
-- ----------------------------
DROP TABLE IF EXISTS `user_operation_token`;
CREATE TABLE `user_operation_token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL,
  `token` varchar(256) NOT NULL,
  `type` varchar(16) NOT NULL,
  `created_time` datetime NOT NULL,
  `expiration_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `user_shopkeeper`
-- ----------------------------
DROP TABLE IF EXISTS `user_shopkeeper`;
CREATE TABLE `user_shopkeeper` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) NOT NULL,
  `latest_login_time` datetime NOT NULL,
  `modified_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
