CREATE DATABASE `manufacturer_db` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `drivers` (
                           `driver_id` int NOT NULL AUTO_INCREMENT,
                           `driver_name` varchar(45) DEFAULT NULL,
                           `driver_license` varchar(45) DEFAULT NULL,
                           `deleted` tinyint NOT NULL DEFAULT '0',
                           PRIMARY KEY (`driver_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `manufacturers` (
                                 `manufacturer_id` int NOT NULL AUTO_INCREMENT,
                                 `manufacturer_name` varchar(45) DEFAULT NULL,
                                 `manufacturer_country` varchar(45) DEFAULT NULL,
                                 `deleted` tinyint NOT NULL DEFAULT '0',
                                 PRIMARY KEY (`manufacturer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
