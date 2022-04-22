CREATE TABLE `drivers` (
                           `id` BIGINT NOT NULL AUTO_INCREMENT,
                           `name` VARCHAR(255) NOT NULL,
                           `licenseNumber` VARCHAR(255) NOT NULL,
                           `is_deleted` TINYINT NOT NULL DEFAULT 0,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `manufacturers` (
                           `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                           `name` VARCHAR(255) NOT NULL,
                           `country` VARCHAR(255) NOT NULL,
                           `is_deleted` TINYINT NOT NULL DEFAULT 0,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

