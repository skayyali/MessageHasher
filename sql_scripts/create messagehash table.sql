CREATE DATABASE springmvcdemo;

USE springmvcdemo;

CREATE TABLE messagehash (
	message varchar(255) NOT NULL,
    digest varchar(64),
    
    PRIMARY KEY(message)
);