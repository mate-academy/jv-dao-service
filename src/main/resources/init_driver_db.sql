CREATE SCHEMA IF NOT EXISTS `drivers` DEFAULT CHARACTER SET utf8;
USE `drivers`;

CREATE TABLE `drivers` (
  `id` bigint NOT NULL,
  `name` varchar(225) NOT NULL,
  `license_number` varchar(225) NOT NULL,
  `is_deleted` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

