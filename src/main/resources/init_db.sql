CREATE SCHEMA IF NOT EXISTS `taxi_service_db` DEFAULT CHARACTER SET utf8;
USE `taxi_service_db`;

CREATE TABLE `manufacturers` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(225) NOT NULL,
  `country` VARCHAR(225) NOT NULL,
  `is_deleted` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`));

CREATE TABLE `drivers` (
  `id` BIGINT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `license_number` VARCHAR(45) NOT NULL,
  `is_deleted` TINYINT NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

