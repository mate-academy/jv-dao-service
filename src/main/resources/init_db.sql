CREATE SCHEMA IF NOT EXISTS `taxis_db` DEFAULT CHARACTER SET utf8;
USE `taxis_db`;

CREATE TABLE `manufacturers` (
                                        `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                        `name` VARCHAR(225) NOT NULL,
                                        `country` VARCHAR(225) NOT NULL,
                                        `is_deleted` TINYINT NOT NULL DEFAULT 0,
                                        PRIMARY KEY (`id`));

CREATE TABLE `drivers` (
                                        `id` BIGINT NOT NULL AUTO_INCREMENT,
                                        `name` VARCHAR(255) NOT NULL,
                                        `license_number` VARCHAR(255) NOT NULL,
                                        `is_deleted` TINYINT NOT NULL DEFAULT '0',
                                        PRIMARY KEY (`id`));
