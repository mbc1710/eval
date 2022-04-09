DROP TABLE IF EXISTS database.price_entity CASCADE;

DROP TABLE IF EXISTS database.brand_entity CASCADE;

DROP SEQUENCE  IF EXISTS sq_prices_entity;

DROP SEQUENCE  IF EXISTS sq_brand_entity;

drop schema IF exists database;

create schema database;

set schema database;

CREATE SEQUENCE sq_prices_entity
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
;

CREATE SEQUENCE sq_brand_entity
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
;

CREATE TABLE database.brand_entity(
	brand_id integer(2) NOT NULL DEFAULT nextval('sq_brand_entity'),
	description varchar(50) NOT NULL
);

CREATE TABLE database.price_entity(
	price_id integer NOT NULL DEFAULT nextval('sq_prices_entity'),
	brand_id integer(2) NOT NULL,
	start_date timestamp NOT NULL,
	end_date timestamp NOT NULL,
	product_id integer(10) NOT NULL,
	priority integer(2) NOT NULL,
	price decimal(10,2) NOT NULL,	
	curr varchar(3) NOT NULL
);

ALTER TABLE brand_entity ADD CONSTRAINT PK_brand_entity PRIMARY KEY (brand_id);

ALTER TABLE price_entity ADD CONSTRAINT PK_price_entity PRIMARY KEY (price_id);

CREATE INDEX index_price_entity ON price_entity (product_id ASC);

ALTER TABLE price_entity ADD CONSTRAINT foreign_key_brand_id FOREIGN KEY (brand_id) REFERENCES brand_entity (brand_id);

/* inserts brand entity */ 
INSERT INTO database.brand_entity VALUES(1, 'Zara');

/* inserts prices entity */
INSERT INTO database.price_entity VALUES(1,1,'2020-06-14 00:00:00','2020-12-30 23:59:59',35455,0,35.50,'EUR');
INSERT INTO database.price_entity VALUES(2,1,'2020-06-14 15:00:00','2020-06-14 14:18:30',35455,1,25.45,'EUR');
INSERT INTO database.price_entity VALUES(3,1,'2020-06-15 00:00:00','2020-06-15 11:00:00',35455,1,30.50,'EUR');
INSERT INTO database.price_entity VALUES(4,1,'2020-06-15 16:00:00','2020-12-31 23:59:59',35455,1,38.95,'EUR');

