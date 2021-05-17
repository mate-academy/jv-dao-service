CREATE DATABASE `manufacturers_db` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
CREATE TABLE `manufacturers` (
                                 `id` bigint NOT NULL AUTO_INCREMENT,
                                 `name` varchar(255) DEFAULT NULL,
                                 `country` varchar(255) DEFAULT NULL,
                                 `is_deleted` tinyint DEFAULT '0',
                                 PRIMARY KEY (`manufacturer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `drivers` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `name` varchar(255) DEFAULT NULL,
                           `license_number` varchar(255) DEFAULT NULL,
                           `is_deleted` tinyint DEFAULT '0',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;
