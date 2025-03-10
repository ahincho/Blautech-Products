-- V3 Create Categories Table
CREATE TABLE categories (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(256) NOT NULL UNIQUE,
    description TEXT NULL,
    image VARCHAR(255)
);
