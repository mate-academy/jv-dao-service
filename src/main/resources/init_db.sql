CREATE DATABASE `taxi_db` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `drivers` (
                           `name` varchar(55) DEFAULT NULL,
                           `license_number` varchar(45) DEFAULT NULL,
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `manufacturers` (
                                 `name` varchar(25) DEFAULT NULL,
                                 `country` varchar(45) DEFAULT NULL,
                                 `id` bigint NOT NULL AUTO_INCREMENT,
                                 `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
