CREATE SCHEMA IF NOT EXISTS `taxi_service` DEFAULT CHARACTER SET utf8;
USE `taxi_service`;

CREATE TABLE `manufacturers` (
                              `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                              `name` VARCHAR(225) NOT NULL,
                              `country` VARCHAR(225) NOT NULL,
                              `is_deleted` TINYINT NOT NULL DEFAULT 0,
                              PRIMARY KEY (`id`));
CREATE TABLE `drivers` (
                              `id` bigint NOT NULL AUTO_INCREMENT,
                              `name` varchar(255) NOT NULL,
                              `license_number` varchar(255) NOT NULL,
                              `is_deleted` TINYINT NOT NULL DEFAULT 0,
                              PRIMARY KEY (`id`));
INSERT INTO `taxi_service`.`drivers` (`id`, `name`, `license_number`, `is_deleted`) VALUES ('1', 'Alice', '999-444', '0');
INSERT INTO `taxi_service`.`drivers` (`id`, `name`, `license_number`, `is_deleted`) VALUES ('2', 'Tom', '773-344', '0');
INSERT INTO `taxi_service`.`manufacturers` (`id`, `name`, `country`, `is_deleted`) VALUES ('1', 'Renault', 'France', '0');
INSERT INTO `taxi_service`.`manufacturers` (`id`, `name`, `country`, `is_deleted`) VALUES ('2', 'VW', 'Germany', '0');
