CREATE DATABASE `taxi_db` /*!40100 DEFAULT CHARACTER SET utf8mb3 */;

CREATE TABLE `manufacturers` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `name` varchar(100) DEFAULT NULL,
                            `country` varchar(100) DEFAULT NULL,
                            `is_deleted` tinyint NOT NULL DEFAULT '0',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `drivers` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `name` varchar(100) DEFAULT NULL,
                           `license_number` varchar(100) DEFAULT NULL,
                           `is_deleted` tinyint NOT NULL DEFAULT '0',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

