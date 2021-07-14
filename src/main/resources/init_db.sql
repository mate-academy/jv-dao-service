CREATE SCHEMA IF NOT EXISTS `taxi` DEFAULT CHARACTER SET utf8;
USE `taxi`;

CREATE TABLE `manufacturers` (
                                        `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                        `name` VARCHAR(225) NOT NULL,
                                        `country` VARCHAR(225) NOT NULL,
                                        `is_deleted` TINYINT NOT NULL DEFAULT 0,
                                        PRIMARY KEY (`id`));

CREATE TABLE `taxi`.`drivers` (
                                          `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                          `name` VARCHAR(45) NULL,
                                          `licence_number` VARCHAR(20) NULL,
                                          `is_deleted` TINYINT NOT NULL DEFAULT 0,
                                          PRIMARY KEY (`id`));

INSERT INTO `taxi`.`manufacturers` (`name`, `country`) VALUES ('Ford', 'USA');
INSERT INTO `taxi`.`manufacturers` (`name`, `country`) VALUES ('Maserati', 'Italy');
INSERT INTO `taxi`.`manufacturers` (`name`, `country`) VALUES ('Mazda', 'Japan');
INSERT INTO `taxi`.`manufacturers` (`name`, `country`) VALUES ('McLaren', 'England');
INSERT INTO `taxi`.`manufacturers` (`name`, `country`) VALUES ('Mercedes-Benz', 'Jermany');

INSERT INTO `taxi`.`drivers` (`name`, `licence_number`) VALUES ('Dopinder', 'MH1420110062821');
INSERT INTO `taxi`.`drivers` (`name`, `licence_number`) VALUES ('Johny English', 'RT1939473219432');
INSERT INTO `taxi`.`drivers` (`name`, `licence_number`) VALUES ('Daniel', 'TY3829104372431');
INSERT INTO `taxi`.`drivers` (`name`, `licence_number`) VALUES ('Baby', 'OI9304127473244');
INSERT INTO `taxi`.`drivers` (`name`, `licence_number`) VALUES ('Dominic', 'DG9432103471241');
