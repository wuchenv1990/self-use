DROP DATABASE IF EXISTS test_mybatis_db;
CREATE DATABASE test_mybatis_db;

DROP TABLE IF EXISTS TBL_USER;
CREATE TABLE TBL_USER (
   uid BIGINT PRIMARY KEY auto_increment,
   name VARCHAR(255) NOT NULL UNIQUE,
   passwd VARCHAR(255) DEFAULT "passwd"
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS TBL_GROUP;
CREATE TABLE TBL_GROUP (
   gid BIGINT PRIMARY KEY auto_increment,
   name VARCHAR(255) NOT NULL UNIQUE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS TBL_USER_TO_GROUP;
CREATE TABLE TBL_USER_TO_GROUP (
    id BIGINT PRIMARY KEY auto_increment,
    uid INT NOT NULL,
    gid INT NOT NULL,
    UNIQUE KEY unique_ug(uid, gid),
    INDEX idx_ug(uid, gid),
    INDEX idx_gu(gid, uid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT TBL_GROUP(`name`) values ("root");
INSERT TBL_USER(`name`, `passwd`) values ("root", "root");
INSERT TBL_USER_TO_GROUP(uid, gid) values (1, 1);
