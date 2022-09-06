CREATE SCHEMA if NOT EXISTS `taxi_service` DEFAULT CHARACTER SET utf8;
USE `taxi_service`;

CREATE TABLE `manufacturers` (
  `id` bigint(11) NOT NULL auto_increment,
  `name` VARCHAR(225) NOT NULL,
  `country` VARCHAR(225) NOT NULL,
  `is_deleted` tinyint NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`));

CREATE TABLE `drivers` (
  `id` bigint NOT NULL auto_increment,
  `name` varchar(255) NOT NULL,
  `licenseNumber` varchar(45) NOT NULL,
  `is_deleted` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) engine=InnoDB DEFAULT charset=utf8mb3;
