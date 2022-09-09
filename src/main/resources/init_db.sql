CREATE SCHEMA IF NOT EXISTS `taxi_service_db` DEFAULT CHARACTER SET utf8;
USE `taxi_service_db`;

CREATE TABLE `manufacturers` (
        `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
        `name` VARCHAR(45) NOT NULL,
        `country` VARCHAR(45) NOT NULL,
        `is_deleted` TINYINT NOT NULL DEFAULT 0,
        PRIMARY KEY (`id`));

CREATE TABLE `drivers` (
       `id` bigint NOT NULL AUTO_INCREMENT,
       `name` varchar(45) NOT NULL,
       `license_number` varchar(45) NOT NULL,
       `is_deleted` tinyint NOT NULL DEFAULT '0',
       PRIMARY KEY (`id`))
    ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

