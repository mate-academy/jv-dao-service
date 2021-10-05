CREATE SCHEMA IF NOT EXISTS `taxi` DEFAULT CHARACTER SET utf8;
USE `taxi`;

CREATE TABLE `manufacturers` (
                                        `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                        `name` VARCHAR(225) NOT NULL,
                                        `country` VARCHAR(225) NOT NULL,
                                        `is_deleted` TINYINT NOT NULL DEFAULT 0,
                                        PRIMARY KEY (`id`));
CREATE TABLE `taxi_db`.`drivers` (
                                     `id` BIGINT NOT NULL AUTO_INCREMENT,
                                     `name` VARCHAR(255) NOT NULL,
                                     `licence_number` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_general_ci' NOT NULL,
                                     `is_deleted` TINYINT NOT NULL DEFAULT 0,
                                     PRIMARY KEY (`id`));

