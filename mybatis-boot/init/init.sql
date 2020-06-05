DROP DATABASE IF EXISTS `test_mybatis_db`;
CREATE DATABASE `test_mybatis_db`;
USE `test_mybatis_db`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
   `uid` BIGINT PRIMARY KEY auto_increment,
   `name` VARCHAR(255) NOT NULL UNIQUE,
   `passwd` VARCHAR(255) DEFAULT "passwd"
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
   `gid` BIGINT PRIMARY KEY auto_increment,
   `name` VARCHAR(255) NOT NULL UNIQUE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `user_to_group`;
CREATE TABLE `user_to_group` (
    `id` BIGINT PRIMARY KEY auto_increment,
    `uid` INT NOT NULL,
    `gid` INT NOT NULL,
    UNIQUE KEY unique_ug(`uid`, `gid`),
    INDEX `idx_ug`(`uid`, `gid`),
    INDEX `idx_gu`(`gid`, `uid`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT `group`(`name`) values ("root");
INSERT `user`(`name`, `passwd`) values ("root", "root");
INSERT `user_to_group`(`uid`, `gid`) values (1, 1);
