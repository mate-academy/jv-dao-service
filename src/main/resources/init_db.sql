CREATE SCHEMA IF NOT EXISTS `taxi` DEFAULT CHARACTER SET utf8;
USE `taxi`;

CREATE TABLE `manufacturers` (
                                        `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                        `name` VARCHAR(225) NOT NULL,
                                        `country` VARCHAR(225) NOT NULL,
                                        `is_deleted` TINYINT NOT NULL DEFAULT 0,
                                        PRIMARY KEY (`id`));

INSERT INTO `taxi`.`manufacturers` (`name`, `country`) VALUES ('Li', 'China');
INSERT INTO `taxi`.`manufacturers` (`name`, `country`) VALUES ('Smith', 'Great Britain');
INSERT INTO `taxi`.`manufacturers` (`name`, `country`) VALUES ('Tompson', 'USA');
INSERT INTO `taxi`.`manufacturers` (`name`, `country`) VALUES ('Kovalchuk', 'Ukraine');
INSERT INTO `taxi`.`manufacturers` (`name`, `country`) VALUES ('Jobs', 'USA');
INSERT INTO `taxi`.`manufacturers` (`name`, `country`, 'is_deleted') VALUES ('Duda', 'Poland', '1');

CREATE TABLE `drivers` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `name` varchar(225) NOT NULL,
                           `license_number` varchar(225) NOT NULL,
                           `is_deleted` tinyint NOT NULL DEFAULT '0',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

INSERT INTO `taxi`.`drivers` (`name`, `license_number`) VALUES ('Polly', 'GHJ55');
INSERT INTO `taxi`.`drivers` (`name`, `license_number`) VALUES ('Nina', '90JKL');
INSERT INTO `taxi`.`drivers` (`name`, `license_number`, 'is_deleted') VALUES ('Duda', 'FGA89', '1');



