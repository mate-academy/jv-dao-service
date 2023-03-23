CREATE SCHEMA IF NOT EXISTS `taxi_service` DEFAULT CHARACTER SET utf8;
USE `taxi_service`;

CREATE TABLE `manufacturers` (
                                        `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                        `name` VARCHAR(225) NOT NULL,
                                        `country` VARCHAR(225) NOT NULL,
                                        `is_deleted` TINYINT NOT NULL DEFAULT 0,
                                        PRIMARY KEY (`id`));
CREATE TABLE `taxi_service`.`drivers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `licenseNumber` VARCHAR(45) NOT NULL,
  `is_deleted` TINYINT NOT NULL,
  PRIMARY KEY (`id`));
ALTER TABLE `taxi_service`.`drivers`
CHANGE COLUMN `name` `name` VARCHAR(255) NOT NULL ,
CHANGE COLUMN `licenseNumber` `licenseNumber` VARCHAR(255) NOT NULL ,
CHANGE COLUMN `is_deleted` `is_deleted` TINYINT NOT NULL DEFAULT 0 ;
