CREATE DATABASE `library_db` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `library_db`.`drivers` (
`id` BIGINT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`licenseNumber` VARCHAR(45) NOT NULL,
`deleted` TINYINT NOT NULL DEFAULT 0,
 PRIMARY KEY (`id`, `name`, `licenseNumber`));
