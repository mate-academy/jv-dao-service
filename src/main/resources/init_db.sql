CREATE DATABASE `taxi_service_db` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `manufacturers` (
                                 `id` BIGINT NOT NULL AUTO_INCREMENT,
                                 `name` VARCHAR(45) DEFAULT NULL,
                                 `country` VARCHAR(45) DEFAULT NULL,
                                 `is_deleted` TINYINT DEFAULT '0',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `drivers` (
                           `id` BIGINT NOT NULL AUTO_INCREMENT,
                           `name` VARCHAR(45) DEFAULT NULL,
                           `driver_license` VARCHAR(45) DEFAULT NULL,
                           `is_deleted` TINYINT DEFAULT '0',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
