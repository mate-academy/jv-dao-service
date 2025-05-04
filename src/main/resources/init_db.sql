CREATE DATABASE `library_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
CREATE TABLE `manufacturers` (
  `name` varchar(111) DEFAULT NULL,
  `country` varchar(111) DEFAULT NULL,
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;
CREATE TABLE `drivers` (
  `name` varchar(211) DEFAULT NULL,
  `license_number` varchar(211) DEFAULT NULL,
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `is_deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
