CREATE DATABASE `taxi_service` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin DEFAULT ENCRYPTION='N';
CREATE TABLE `drivers` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                           `license_number` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                           `is_deleted` tinyint NOT NULL DEFAULT '0',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
CREATE TABLE `manufacturers` (
                                 `id` bigint NOT NULL AUTO_INCREMENT,
                                 `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                 `country` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                 `is_deleted` tinyint NOT NULL DEFAULT '0',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
