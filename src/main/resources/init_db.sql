CREATE SCHEMA IF NOT EXISTS `taxi_service` DEFAULT CHARACTER SET utf8;
USE `taxi_service`;

CREATE TABLE `manufacturers` (
                                        `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                          `name` VARCHAR(225) DEFAULT NULL,
                                          `country` VARCHAR(225) DEFAULT NULL,
                                          `is_deleted` TINYINT DEFAULT '0',
                                          PRIMARY KEY (`id`)
                                        ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
CREATE TABLE `drivers` (
                                        `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                        `name` VARCHAR(225) DEFAULT NULL,
                                        `license_number` VARCHAR(225) DEFAULT NULL,
                                        `is_deleted` TINYINT DEFAULT '0',
                                        PRIMARY KEY (`id`)
                                        ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

