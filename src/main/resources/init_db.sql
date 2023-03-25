-- Database: mate

-- DROP DATABASE IF EXISTS mate;

CREATE DATABASE mate
    WITH
    OWNER = mate
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

-- Table: public.manufacturers

-- DROP TABLE IF EXISTS public.manufacturers;

CREATE TABLE public.manufacturers
(
    id bigserial NOT NULL UNIQUE,
    name character varying(255) COLLATE pg_catalog."default",
    country character varying(255) COLLATE pg_catalog."default",
    is_deleted boolean NOT NULL DEFAULT 'false',
    CONSTRAINT manufacturers_pkey PRIMARY KEY (id)
)

-- Table: public.drivers

-- DROP TABLE IF EXISTS public.drivers;

CREATE TABLE public.drivers
(
    id bigserial NOT NULL UNIQUE,
    name character varying(255) COLLATE pg_catalog."default",
    license_number character varying(255) COLLATE pg_catalog."default",
    is_deleted boolean NOT NULL DEFAULT 'false',
    CONSTRAINT drivers_pkey PRIMARY KEY (id)
)
