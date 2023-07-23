CREATE SCHEMA IF NOT EXISTS `taxi_service` DEFAULT CHARACTER SET utf8;
USE `taxi_service`;

CREATE TABLE `manufacturers` (
                                        `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                        `name` VARCHAR(225) NOT NULL,
                                        `country` VARCHAR(225) NOT NULL,
                                        `is_deleted` TINYINT NOT NULL DEFAULT 0,
                                        PRIMARY KEY (`id`));
--Init table
INSERT INTO `taxi_service_db`.`manufacturers` (`name`, `country`) VALUES ('Ford', 'USA');
INSERT INTO `taxi_service_db`.`manufacturers` (`name`, `country`) VALUES ('Tavria', 'Ukraine');
INSERT INTO `taxi_service_db`.`manufacturers` (`name`, `country`) VALUES ('Fiat', 'Italy');
INSERT INTO `taxi_service_db`.`manufacturers` (`name`, `country`) VALUES ('AstonMartin', 'Great Britain');
INSERT INTO `taxi_service_db`.`manufacturers` (`name`, `country`) VALUES ('Renault', 'France');
INSERT INTO `taxi_service_db`.`manufacturers` (`name`, `country`) VALUES ('Ferrari', 'Italy');
INSERT INTO `taxi_service_db`.`manufacturers` (`name`, `country`) VALUES ('Lada', 'USSR');
INSERT INTO `taxi_service_db`.`manufacturers` (`name`, `country`) VALUES ('Volvo', 'Sweden');
INSERT INTO `taxi_service_db`.`manufacturers` (`name`, `country`) VALUES ('Saab', 'Sweden');
INSERT INTO `taxi_service_db`.`manufacturers` (`name`, `country`) VALUES ('Tesla', 'USA');



CREATE TABLE `drivers` (
            `id` bigint NOT NULL AUTO_INCREMENT,
            `name` varchar(255) NOT NULL,
            `license_number` varchar(255) NOT NULL,
            `is_deleted` tinyint NOT NULL DEFAULT '0',
                PRIMARY KEY (`id`)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
--Init table
INSERT INTO `taxi_service_db`.`drivers` (`name`, `license_number`) VALUES ('Bob', '123546Q123');
INSERT INTO `taxi_service_db`.`drivers` (`name`, `license_number`) VALUES ('Nik', '2453sd134');
INSERT INTO `taxi_service_db`.`drivers` (`name`, `license_number`) VALUES ('Alex', '876a98');
INSERT INTO `taxi_service_db`.`drivers` (`name`, `license_number`) VALUES ('Jack', '767i987');
INSERT INTO `taxi_service_db`.`drivers` (`name`, `license_number`) VALUES ('Timur', '87690m979');
INSERT INTO `taxi_service_db`.`drivers` (`name`, `license_number`) VALUES ('Vovik', '78687i7587');

