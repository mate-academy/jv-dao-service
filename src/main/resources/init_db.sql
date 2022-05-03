CREATE DATABASE 'transport_db';
CREATE TABLE 'drivers' (
    'id' BIGINT NOT NULL AUTO_INCREMENT,
    'name' VARCHAR(255) NULL,
    'licenseNumber' VARCHAR(255) NULL ,
    'is_deleted' TINYINT NOT NULL  DEFAULT  0,
    PRIMARY KEY ('id')
);

CREATE TABLE 'manufacturers' (
    'id' INT NOT NULL AUTO_INCREMENT,
    'name' VARCHAR(255) NULL,
    'country' VARCHAR(255) NULL,
    'is_deleted' TINYINT NOT NULL  DEFAULT  0
);