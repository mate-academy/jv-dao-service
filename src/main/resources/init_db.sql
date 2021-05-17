CREATE DATABASE `manufacturer_db` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `manufacturers` (
                                    `id` bigint NOT NULL AUTO_INCREMENT,
                                    `name` varchar(50) DEFAULT NULL,
                                    `country` varchar(3) DEFAULT NULL,
                                    `is_deleted` tinyint NOT NULL DEFAULT '0',
                                    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `flights` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `number` varchar(10) DEFAULT NULL,
                           `carrier` varchar(50) DEFAULT NULL,
                           `manufacturer_id` int,
                           `is_deleted` tinyint NOT NULL DEFAULT '0',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
