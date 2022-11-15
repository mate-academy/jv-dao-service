CREATE SCHEMA IF NOT EXISTS `taxi_service` DEFAULT CHARACTER SET utf8;
USE `taxi_service`;

CREATE TABLE IF NOT EXISTS `manufacturers` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(225) NOT NULL,
  `country` varchar(225) NOT NULL,
  `is_deleted` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE IF NOT EXISTS `drivers` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(225) NOT NULL,
  `licenseNumber` varchar(255) NOT NULL,
  `is_deleted` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
