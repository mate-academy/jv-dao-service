CREATE DATABASE `new_schema` DEFAULT CHARACTER SET utf8 DEFAULT ENCRYPTION='N';

CREATE TABLE `manufacturers` (
                                        `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                        `name` VARCHAR(225) NOT NULL,
                                        `country` VARCHAR(225) NOT NULL,
                                        `is_deleted` TINYINT NOT NULL DEFAULT 0,
                                        PRIMARY KEY (`id`));

CREATE TABLE `drivers` (
                                        `id` bigint NOT NULL AUTO_INCREMENT,
                                        `name` varchar(45) DEFAULT NULL,
                                        `licenseNumber` varchar(45) DEFAULT NULL,
                                        `is_deleted` tinyint NOT NULL DEFAULT '0',
                                         PRIMARY KEY (`id`);

