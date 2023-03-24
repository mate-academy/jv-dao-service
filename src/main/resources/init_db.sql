CREATE SCHEMA taxi CHARACTER SET utf8mb4;

CREATE TABLE manufacturers (
                              id bigint NOT NULL AUTO_INCREMENT,
                              name varchar(255) DEFAULT NULL,
                              country varchar(255) DEFAULT NULL,
                              is_deleted tinyint NOT NULL DEFAULT 0,
                              PRIMARY KEY (id)
)

CREATE TABLE drivers (
                              id bigint NOT NULL AUTO_INCREMENT,
                              name varchar(255) DEFAULT NULL,
                              license_number varchar(255) DEFAULT NULL,
                              is_deleted tinyint NOT NULL DEFAULT 0,
                              PRIMARY KEY (id)
)
