CREATE SCHEMA IF NOT EXISTS `taxi_service` DEFAULT CHARACTER SET utf8;
USE `taxi_service`;

CREATE TABLE `manufacturers`
(
    `id`         BIGINT(11)   NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(225) NOT NULL,
    `country`    VARCHAR(225) NOT NULL,
    `is_deleted` TINYINT      NOT NULL DEFAULT 0,
    PRIMARY KEY (`id`)
);

create table driver
(
    `id`          bigint(11)   not null auto_increment,
    name          varchar(255) not null,
    licenseNumber varchar(255) not null,
    `driver_deleted` TINYINT      NOT NULL DEFAULT 0,
    primary key (id)
);