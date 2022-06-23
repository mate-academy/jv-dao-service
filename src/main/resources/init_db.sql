CREATE DATABASE `taxi_service_db` DEFAULT CHARSET=utf8;
CREATE TABLE `manufacturers` (
                      `id` bigint NOT NULL AUTO_INCREMENT,
                      `name` varchar(255) NOT NULL,
                      `country` varchar(255) NOT NULL,
                      `is_deleted` tinyint NOT NULL DEFAULT '0',
                      PRIMARY KEY (`id`)
);
CREATE TABLE `drivers` (
                      `id` bigint NOT NULL AUTO_INCREMENT,
                      `name` varchar(255) NOT NULL,
                      `license_number` varchar(255) NOT NULL,
                      `is_deleted` tinyint NOT NULL DEFAULT '0',
                      PRIMARY KEY (`id`),
                      UNIQUE KEY `license_number_UNIQUE` (`license_number`)
);
