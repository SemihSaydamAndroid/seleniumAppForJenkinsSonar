CREATE DATABASE IF NOT EXISTS test_database;
USE test_database;

CREATE TABLE IF NOT EXISTS test_results (
    id INT AUTO_INCREMENT PRIMARY KEY,
    passed INT,
    failed INT,
    duration INT  -- duration sütunu INT tipinde oluşturulmuştur.
);