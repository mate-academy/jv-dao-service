CREATE DATABASE `taxi_service` DEFAULT CHARACTER SET utf8 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `drivers` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `name` varchar(255) DEFAULT NULL,
                           `licenseNumber` varchar(255) DEFAULT NULL,
                           `is_deleted` tinyint NOT NULL DEFAULT '0',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `manufacturers` (
                                 `id` bigint NOT NULL AUTO_INCREMENT,
                                 `name` varchar(255) DEFAULT NULL,
                                 `country` varchar(255) DEFAULT NULL,
                                 `is_deleted` tinyint NOT NULL DEFAULT '0',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;
