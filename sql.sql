DROP DATABASE IF EXISTS labsbackend;
CREATE DATABASE labsbackend;
USE labsbackend;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS records;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS currencies;

SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE currencies (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(10) NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    default_currency_id BIGINT,
    CONSTRAINT fk_default_currency FOREIGN KEY (default_currency_id) REFERENCES currencies(id)
);

CREATE TABLE categories (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE records (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    currency_id BIGINT,
    created_at DATETIME NOT NULL,
    amount DOUBLE NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES categories(id),
    CONSTRAINT fk_currency FOREIGN KEY (currency_id) REFERENCES currencies(id)
);

INSERT INTO currencies (id, code, name)
VALUES
    (1, 'USD', 'US Dollar'),
    (2, 'EUR', 'Euro'),
    (3, 'UAH', 'Ukrainian Hryvnia');

INSERT INTO users (name, default_currency_id) 
VALUES 
    ('Slim Shady', 1),
    ('LanaDel Rey', 2);

INSERT INTO categories (name) 
VALUES 
    ('Food'),
    ('Transport'),
    ('Utilities');

INSERT INTO records (user_id, category_id, currency_id, created_at, amount) 
VALUES 
    (1, 1, 1, NOW(), 50.00),
    (2, 2, 2, NOW(), 30.00);

