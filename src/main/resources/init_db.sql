CREATE DATABASE taxi_service DEFAULT CHAR SET utf8mb4;

USE `taxi_service`;

CREATE TABLE manufacturers (
	`id` BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(64) NULL,
    `country` VARCHAR(32) NULL,
    `is_deleted` TINYINT NOT NULL DEFAULT FALSE
);

CREATE TABLE drivers (
	`id` BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(64) NULL,
    `license_number` VARCHAR(32) NULL,
    `is_deleted` TINYINT NOT NULL DEFAULT FALSE
);
