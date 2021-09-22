/* Table "drivers"*/
CREATE TABLE `drivers` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(255) DEFAULT NULL,
    `licence_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `is_deleted` tinyint NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;

INSERT INTO `drivers` (`id`, `name`, `licence_number`, `is_deleted`) VALUES
(14, 'Bob', 'NM395873057', 0),
(15, 'Meggie', 'ZL982729842', 1),
(16, 'Simon', 'GD283482462', 0);

/* Table "manufacturers"*/
CREATE TABLE `manufacturers` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(255) DEFAULT NULL,
    `country` varchar(255) DEFAULT NULL,
    `is_deleted` tinyint NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb3;

INSERT INTO `manufacturers` (`id`, `name`, `country`, `is_deleted`) VALUES
(1, 'ZAZ', 'Ukraine', 1),
(2, 'Skoda', 'Czech Republic', 0),
(3, 'BMW', 'Germany', 0),
(5, 'Kraz', 'Ukraine', 0),
(6, 'LAZ', 'Ukraine', 1),
(39, 'Saab', 'Sweden', 1),
(40, 'Bentley', 'Germany', 0);
