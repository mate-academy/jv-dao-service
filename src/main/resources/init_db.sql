CREATE DATABASE `manufacturer_db` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `drivers` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `name` varchar(45) DEFAULT NULL,
                           `license_number` varchar(45) DEFAULT NULL,
                           `deleted` tinyint NOT NULL DEFAULT '0',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;


CREATE TABLE `manufacturers` (
                                 `id` int NOT NULL AUTO_INCREMENT,
                                 `name` varchar(45) DEFAULT NULL,
                                 `country` varchar(45) DEFAULT NULL,
                                 `deleted` tinyint NOT NULL DEFAULT '0',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
