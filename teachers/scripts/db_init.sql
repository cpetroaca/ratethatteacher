CREATE DATABASE IF NOT EXISTS ratethatteacher;

CREATE TABLE schools(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(100),
	locationName VARCHAR(50),
	locationPoint POINT,
	PRIMARY KEY (id)
);

CREATE TABLE users(
	id INT NOT NULL AUTO_INCREMENT,
	fullName VARCHAR(50),
	PRIMARY KEY (id)
);

CREATE TABLE teachers(
	id INT NOT NULL AUTO_INCREMENT,
	fullName varchar(50),
	schoolId INT,
	overallRating FLOAT,
	PRIMARY KEY (id),
	FOREIGN KEY (schoolId) REFERENCES schools(id)
);

CREATE TABLE ratings(
	id INT NOT NULL AUTO_INCREMENT,
	userId INT,
	teacherId INT,
	educationalProwess TINYINT,
	emotionalImpact TINYINT,
	creativityBooster TINYINT,
	parentsInteraction TINYINT,
	comment VARCHAR(200),
	PRIMARY KEY (id),
	FOREIGN KEY (userId) REFERENCES users(id),
	FOREIGN KEY (teacherId) REFERENCES teachers(id)
);

