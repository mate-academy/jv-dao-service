CREATE DATABASE `taxi_app_db` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `manufacturers` (
                                        `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                        `name` VARCHAR(225) NOT NULL,
                                        `country` VARCHAR(225) NOT NULL,
                                        `is_deleted` TINYINT NOT NULL DEFAULT 0,
                                        PRIMARY KEY (`id`));

CREATE TABLE `drivers` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `license_number` varchar(8) NOT NULL,
  `is_deleted` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
