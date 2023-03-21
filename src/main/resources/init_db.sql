create SCHEMA IF NOT EXISTS `taxi_service` DEFAULT CHARACTER SET utf8;
USE `taxi_service`;

create TABLE `manufacturers` (
`id` BIGINT(11) NOT NULL AUTO_INCREMENT,
`name` VARCHAR(225) NOT NULL,
`country` VARCHAR(225) NOT NULL,
`is_deleted` TINYINT NOT NULL DEFAULT 0,
PRIMARY KEY (`id`));

create TABLE `taxi_service_db`.`drivers` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `license_number` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `is_deleted` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
