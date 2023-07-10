-- Tables creating:

CREATE TABLE sql7630939.manufacturers (
	id INT auto_increment NOT NULL,
	name varchar(250) NOT NULL,
	country varchar(250) NOT NULL,
	is_deleted BIT DEFAULT false NOT NULL,
	CONSTRAINT Manufacturers_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;

CREATE TABLE sql7630939.drivers (
	id BIGINT auto_increment NOT NULL,
	name varchar(250) NOT NULL,
	licensenumber varchar(250) NOT NULL,
	is_deleted BIT DEFAULT false NOT NULL,
	CONSTRAINT Drivers_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;
