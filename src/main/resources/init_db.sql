CREATE SCHEMA IF NOT EXISTS `taxi_service` DEFAULT CHARACTER SET utf8;
USE `taxi_service`;

CREATE TABLE `manufacturers` (
                                          `id` bigint NOT NULL AUTO_INCREMENT,
                                          `name` varchar(255) DEFAULT NULL,
                                          `country` varchar(255) DEFAULT NULL,
                                          `is_deleted` tinyint DEFAULT '0',
                                           PRIMARY KEY (`id`))
                                           ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `drivers` (
                                        `id` bigint NOT NULL AUTO_INCREMENT,
                                        `name` varchar(255) DEFAULT NULL,
                                        `license` varchar(255) DEFAULT NULL,
                                        `is_deleted` tinyint DEFAULT '0',
                                         PRIMARY KEY (`id`))
                                         ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
