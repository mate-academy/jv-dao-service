CREATE SCHEMA IF NOT EXISTS `taxi_service` DEFAULT CHARACTER SET utf8;
USE `taxi_service`;

CREATE TABLE `drivers` (
                                             `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                             `name` VARCHAR(255) NULL,
                                             `license_number` VARCHAR(255) NULL,
                                             `is_deleted` TINYINT(1) NOT NULL DEFAULT 0,
                                             PRIMARY KEY (`id`));

CREATE TABLE `manufacturers` (
                                                   `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                                   `name` VARCHAR(255) NULL,
                                                   `country` VARCHAR(255) NULL,
                                                   `is_deleted` TINYINT(1) NOT NULL DEFAULT 0,
                                                   PRIMARY KEY (`id`));
