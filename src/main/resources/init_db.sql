CREATE SCHEMA IF NOT EXISTS `taxi_service` DEFAULT CHARACTER SET utf8;
USE `taxi_service`;

CREATE TABLE `manufacturers` (
          `id` bigint NOT NULL AUTO_INCREMENT,
          `name` varchar(45) DEFAULT NULL,
          `country` varchar(45) DEFAULT NULL,
          `is_deleted` tinyint NOT NULL DEFAULT '0',
          PRIMARY KEY (`id`)
);

CREATE TABLE `drivers` (
          `id` bigint NOT NULL AUTO_INCREMENT,
          `name` varchar(45) DEFAULT NULL,
          `license_number` varchar(45) DEFAULT NULL,
          `is_deleted` tinyint NOT NULL DEFAULT '0',
          PRIMARY KEY (`id`)
);
