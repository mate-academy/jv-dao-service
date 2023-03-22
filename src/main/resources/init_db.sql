CREATE DATABASE `taxi_db` /*!40100 DEFAULT CHARACTER SET utf8mb3 */;

CREATE TABLE `manufacturers` (
                            `id` BIGINT NOT NULL AUTO_INCREMENT,
                            `name` VARCHAR(100) DEFAULT NULL,
                            `country` VARCHAR(100) DEFAULT NULL,
                            `is_deleted` TINYINT NOT NULL DEFAULT '0',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `drivers` (
                           `id` BIGINT NOT NULL AUTO_INCREMENT,
                           `name` VARCHAR(100) DEFAULT NULL,
                           `license_number` VARCHAR(100) DEFAULT NULL,
                           `is_deleted` TINYINT NOT NULL DEFAULT '0',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
