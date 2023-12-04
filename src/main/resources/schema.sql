CREATE DATABASE IF NOT EXISTS springBootLab2;
USE springBootLab2;
CREATE TABLE IF NOT EXISTS category(
        id int PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(255),
        description TEXT);
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





