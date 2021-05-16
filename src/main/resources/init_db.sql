CREATE
DATABASE `manufacturer_db` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `manufacturers`
(
    `id`         bigint  NOT NULL AUTO_INCREMENT,
    `name`       varchar(255)     DEFAULT NULL,
    `country`    varchar(255)     DEFAULT NULL,
    `deleted` tinyint NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `drivers`
(
    `id`             bigint      NOT NULL AUTO_INCREMENT,
    `name`           varchar(50) DEFAULT NULL,
    `license_number` varchar(50) DEFAULT NULL,,
    `deleted`     tinyint     NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3
