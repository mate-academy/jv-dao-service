CREATE TABLE `drivers` (
                           `id` bigint NOT NULL,
                           `name` varchar(255) NOT NULL,
                           `licenseNumber` varchar(255) NOT NULL,
                           `is_deleted` tinyint NOT NULL DEFAULT '0',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3
