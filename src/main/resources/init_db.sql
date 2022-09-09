CREATE SCHEMA IF NOT EXISTS `taxi_service` DEFAULT CHARACTER SET utf8;
USE `taxi_service`;

CREATE TABLE IF NOT EXISTS `manufacturers` (
                                        `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                        `name` VARCHAR(225) NOT NULL,
                                        `country` VARCHAR(225) NOT NULL,
                                        `is_deleted` TINYINT NOT NULL DEFAULT 0,
                                        PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `drivers` (
                                         `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                         `name` VARCHAR(255) NOT NULL,
                                         `license_number` VARCHAR(255) NOT NULL,
                                         `is_deleted` BOOLEAN NOT NULL DEFAULT 0,
                                         PRIMARY KEY (`id`));