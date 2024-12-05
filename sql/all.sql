DROP USER 'dev'@'localhost';
CREATE USER 'dev'@'localhost' IDENTIFIED BY 'qqwwee11@@';
GRANT ALL PRIVILEGES ON *.* TO 'dev'@'localhost';


CREATE DATABASE inumaker24;

USE inumaker24;

DROP TABLE inference_result;
CREATE TABLE inference_result(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    date TIMESTAMP,
    token VARCHAR(40),
    percent DOUBLE
);

SELECT * FROM inference_result;