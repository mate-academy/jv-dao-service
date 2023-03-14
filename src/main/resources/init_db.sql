CREATE SCHEMA IF NOT EXISTS `taxi_service` DEFAULT CHARACTER SET utf8;
USE `taxi_service`;

CREATE TABLE `manufacturers` (
                                          `id` BIGINT NOT NULL AUTO_INCREMENT,
                                          `name` VARCHAR(255) DEFAULT NULL,
                                          `country` VARCHAR(255) DEFAULT NULL,
                                          `is_deleted` tinyint NOT NULL DEFAULT '0',
                                          PRIMARY KEY (`id`)
                                        ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
v

CREATE TABLE `drivers` (
                                          `id` BIGINT NOT NULL AUTO_INCREMENT,
                                          `name` VARCHAR(225) NOT NULL,
                                          `license_number` VARCHAR(225) NOT NULL,
                                          `is_deleted` TINYINT NOT NULL DEFAULT '0',
                                          PRIMARY KEY (`id`)
                                           ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

