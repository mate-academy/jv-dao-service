-- CREATE DATABASE taxi
--     WITH
--     OWNER = postgres
--     ENCODING = 'UTF8'
--     CONNECTION LIMIT = -1;

DROP TABLE IF EXISTS cars;
DROP TABLE IF EXISTS drivers;
DROP TABLE IF EXISTS manufacturers;

CREATE TABLE manufacturers
(
    id        BIGSERIAL,
    name      VARCHAR(100) NOT NULL,
    country   VARCHAR(100) NOT NULL,
    is_deleted boolean DEFAULT false,
    PRIMARY KEY (id)
);

ALTER TABLE manufacturers
    OWNER to postgres;

CREATE TABLE drivers
(
    id         BIGSERIAL,
    name VARCHAR(75) NOT NULL,
    license_number  VARCHAR(155) NOT NULL,
    is_deleted boolean DEFAULT false,
    PRIMARY KEY (id)
);

ALTER TABLE drivers
    OWNER to postgres;

CREATE TABLE cars
(
    id              BIGSERIAL NOT NULL,
    name            VARCHAR(35) NOT NULL,
    color           VARCHAR(35),
    manufacturer_id BIGINT NOT NULL,
    driver_id       BIGINT NOT NULL,
    is_deleted boolean DEFAULT false,
    PRIMARY KEY (id),
    FOREIGN KEY (manufacturer_id) REFERENCES manufacturers (id),
    FOREIGN KEY (driver_id) REFERENCES cars (id)
);

ALTER TABLE cars
    OWNER to postgres;
