CREATE DATABASE `taxi_service` DEFAULT CHARACTER SET utf8 DEFAULT ENCRYPTION='N';

CREATE TABLE `manufacturers` (
                                 `id` bigint NOT NULL AUTO_INCREMENT,
                                 `name` varchar(150) DEFAULT 'null',
                                 `country` varchar(70) DEFAULT 'null',
                                 `is_deleted` tinyint NOT NULL DEFAULT '0',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `drivers` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `name` varchar(255) DEFAULT 'null',
                           `license_number` varchar(255) DEFAULT 'null',
                           `is_deleted` tinyint NOT NULL DEFAULT '0',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
