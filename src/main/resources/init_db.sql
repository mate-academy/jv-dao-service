CREATE SCHEMA IF NOT EXISTS `taxi_service` DEFAULT CHARACTER SET utf8;
USE `taxi_service`;

CREATE TABLE `manufacturers` (
                                        `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                        `name` VARCHAR(225) NOT NULL,
                                        `country` VARCHAR(225) NOT NULL,
                                        `is_deleted` TINYINT NOT NULL DEFAULT 0,
                                        PRIMARY KEY (`id`));

INSERT INTO `taxi_service`.`manufacturers` (`name`, `country`) VALUES ('Toyota', 'Japan'),
 ('Hyundai', 'South Korea'), ('Volkswagen Group', 'Germany'), ('General Motors', 'United States'),
 ('Ford', 'United States'), ('Nissan', 'Japan'), ('Fiat Chrysler Automobiles', 'Italy/United States'),
 ('Renault', 'France'), ('PSA Group', 'France'), ('Suzuki', 'Japan'), ('SAIC', 'China'),
 ('Daimler', 'Germany'), ('BMW', 'Germany'), ('Geely', 'China');

CREATE TABLE `drivers` (
                                        `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                        `name` VARCHAR(225) NOT NULL,
                                        `licenseNumber` VARCHAR(225) NOT NULL,
                                        `is_deleted` TINYINT NOT NULL DEFAULT 0,
                                        PRIMARY KEY (`id`));

INSERT INTO `taxi_service`.`drivers` (`name`, `licenseNumber`)
                            VALUES ('Bob', '55484823'), ('Alice', '6587426');