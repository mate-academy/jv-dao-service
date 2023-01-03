CREATE SCHEMA IF NOT EXISTS `taxi_service` DEFAULT CHARACTER SET utf8;
USE `taxi_service`;

CREATE TABLE `taxi_service`.`manufacturers` (
  `id` BIGINT(11) NOT NULL,
  `name` VARCHAR(255) NULL,
  `country` VARCHAR(255) NULL,
  `is_deleted` TINYINT(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`));
