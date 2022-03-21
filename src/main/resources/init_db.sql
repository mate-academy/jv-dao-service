CREATE SCHEMA IF NOT EXISTS `taxi_service_db` DEFAULT CHARACTER SET utf8;
USE `taxi_service_db`;

CREATE TABLE `manufacturers` (
                                        `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                        `name` VARCHAR(225) NOT NULL,
                                        `country` VARCHAR(225) NOT NULL,
                                        `is_deleted` TINYINT NOT NULL DEFAULT 0,
                                        PRIMARY KEY (`id`));
CREATE TABLE `taxi_service_db`.`driver` (
                                            `id` INT NOT NULL AUTO_INCREMENT,
                                            `name` VARCHAR(255) NOT NULL,
                                            `license_number` BIGINT(10) NOT NULL,
                                            `is_deleted` TINYINT(1) NOT NULL DEFAULT 0,
                                            PRIMARY KEY (`id`));
