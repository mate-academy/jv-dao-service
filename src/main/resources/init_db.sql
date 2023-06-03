CREATE DATABASE `taxi_service_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `manufacturers` (
                                        `id` bigint(11) NOT NULL AUTO_INCREMENT,
                                        `name` varchar(255) DEFAULT NULL,
                                        `country` varchar(255) DEFAULT NULL,
                                        `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
                                        PRIMARY KEY (`id`)
                                        ) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

CREATE TABLE `drivers` (
                                        `id` bigint(11) NOT NULL AUTO_INCREMENT,
                                        `name` varchar(255) DEFAULT NULL,
                                        `licenseNumber` varchar(255) DEFAULT NULL,
                                        `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
                                        PRIMARY KEY (`id`)
                                        ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
