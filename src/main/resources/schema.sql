CREATE DATABASE IF NOT EXISTS springBootLab2;
USE springBootLab2;
CREATE TABLE IF NOT EXISTS category(
        id int PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(255),
        description TEXT(65535));
CREATE TABLE IF NOT EXISTS place(
        id int PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(255),
        categoryId INT,
        userId INT,
        isPrivate BOOL,
        status VARCHAR(6),
        created DATETIME,
        lastUpdated DATETIME,
        description TEXT,
        coordinates POINT);
CREATE TABLE IF NOT EXISTS users(
        id int PRIMARY KEY AUTO_INCREMENT,
        first_name VARCHAR(255),
        last_name VARCHAR(255));





