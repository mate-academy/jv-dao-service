CREATE SCHEMA IF NOT EXISTS `taxi_service` DEFAULT CHARACTER SET utf8;
USE `taxi_service`;
CREATE TABLE `taxi_service`.`manufacturers` (
                                 `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                 `name` VARCHAR(225) NOT NULL,
                                 `country` VARCHAR(225) NOT NULL,
                                 `is_deleted` TINYINT NOT NULL DEFAULT 0,
                                 PRIMARY KEY (`id`));

CREATE TABLE `taxi_service`.`drivers` (
                                            `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                            `name` VARCHAR(255) NOT NULL,
                                            `licenseNumber` VARCHAR(255) NOT NULL,
                                            `is_deleted` TINYINT NOT NULL DEFAULT 0,
                                            PRIMARY KEY (`id`))
    ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
