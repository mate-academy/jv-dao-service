CREATE SCHEMA IF NOT EXISTS `taxi_db` DEFAULT CHARACTER SET utf8;
USE `taxi_db`;

CREATE TABLE `taxi_db`.`manufacturers` (
                                                `id` INT NOT NULL AUTO_INCREMENT,
                                                `name` VARCHAR(255) NULL,
                                                `country` VARCHAR(255) NULL,
                                                `is_deleted` TINYINT NULL DEFAULT 0,
                                                PRIMARY KEY (`id`))
    ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `taxi_db`.`drivers` (
                                          `id` INT NOT NULL AUTO_INCREMENT,
                                          `name` VARCHAR(255) NULL,
                                          `license_number` VARCHAR(255) NULL,
                                          `is_deleted` TINYINT NULL DEFAULT 0,
                                          PRIMARY KEY (`id`))
    ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
