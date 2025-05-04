CREATE SCHEMA IF NOT EXISTS `taxi_service` DEFAULT CHARACTER SET utf8;
USE `taxi_service`;

CREATE TABLE `manufacturers`.`manufacturers` (
  `id` BIGINT(55) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  `is_deleted` TINYINT(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`));

CREATE TABLE `manufacturers`.`drivers` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `license_number` VARCHAR(45) NULL,
  `is_deleted` TINYINT(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`));
