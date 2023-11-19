CREATE DATABASE IF NOT EXISTS Laboration2;
USE Laboration2;
CREATE TABLE IF NOT EXISTS category(
        id int PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(255),
        description TEXT(65535));
CREATE TABLE IF NOT EXISTS place(
        id int PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(255),
        categoryId INT,
        userId INT,
        status VARCHAR(6),
        created DATETIME,
        lastUpdated DATETIME,
        description TEXT(65535),
        coordinates POINT);
CREATE TABLE IF NOT EXISTS users(
        id int PRIMARY KEY AUTO_INCREMENT,
        first_name VARCHAR(255),
        last_name VARCHAR(255));





