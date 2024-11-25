CREATE DATABASE inumaker24;

USE inumaker24;

CREATE TABLE inference_result(
	id BIGINT AUTO_INCREMENT,
    date TIMESTAMP,
    token VARCHAR(20),
    percent DOUBLE
);