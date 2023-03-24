CREATE SCHEMA IF NOT EXISTS taxi_service_database DEFAULT CHARACTER SET utf8;
USE taxi_service_database;

CREATE TABLE taxi_service_database.`manufacturers`(
            `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
            `name` VARCHAR(255) NULL,
            `country` VARCHAR(255) NULL,
            `is_deleted` TINYINT NOT NULL DEFAULT 0,
            PRIMARY KEY (`id`));

CREATE TABLE taxi_service_database.`drivers` (
            `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
            `name` VARCHAR(225) NOT NULL,
            `license_number` VARCHAR(225) NOT NULL,
            `is_deleted` TINYINT NOT NULL DEFAULT 0,
            PRIMARY KEY (`id`));
