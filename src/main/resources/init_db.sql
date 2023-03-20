CREATE SCHEMA IF NOT EXISTS `taxi_service` DEFAULT CHARACTER SET utf8;
USE `taxi_service`;

CREATE TABLE `driver` (
            `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
            `name` VARCHAR(225) NOT NULL,
            `licenseNumber` VARCHAR(225) NOT NULL,
            `is_deleted` TINYINT NOT NULL DEFAULT 0,
            PRIMARY KEY (`id`));
