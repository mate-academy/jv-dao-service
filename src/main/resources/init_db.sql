CREATE SCHEMA IF NOT EXISTS `taxi_service` DEFAULT CHARACTER SET utf8;
USE `taxi_service`;

CREATE TABLE `manufacturers` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `country` VARCHAR(255) NOT NULL,
  `is_deleted` TINYINT NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
);

CREATE TABLE `drivers` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `license_number` VARCHAR(255) NOT NULL,
  `is_deleted` TINYINT NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
);
