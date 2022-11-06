CREATE SCHEMA IF NOT EXISTS `taxi_service` DEFAULT CHARACTER SET utf8;

CREATE TABLE `manufacturers` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(225) NOT NULL,
  `country` varchar(225) NOT NULL,
  `is_deleted` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
);

CREATE TABLE `drivers` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(225) NOT NULL,
  `license_number` varchar(225) NOT NULL,
  `is_deleted` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;