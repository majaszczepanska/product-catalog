--liquibase formatted sql

-- changeset maja:1
CREATE TABLE producers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

-- changeset maja:2
CREATE TABLE products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(1000),
    price DECIMAL(10, 2),
    producer_id BIGINT NOT NULL,
    attributes JSON,
    FOREIGN KEY (producer_id) REFERENCES producers(id)
);