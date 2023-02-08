CREATE DATABASE IF NOT EXISTS ratethatteacher;

CREATE TABLE schools(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(100),
	location_name VARCHAR(50),
	location_point POINT,
	PRIMARY KEY (id)
);

CREATE TABLE users(
	id INT NOT NULL AUTO_INCREMENT,
	full_name VARCHAR(50),
	PRIMARY KEY (id)
);

CREATE TABLE teachers(
	id INT NOT NULL AUTO_INCREMENT,
	full_name varchar(50),
	school_id INT,
	overall_rating FLOAT,
	PRIMARY KEY (id),
	FOREIGN KEY (school_id) REFERENCES schools(id)
);

CREATE TABLE ratings(
	id INT NOT NULL AUTO_INCREMENT,
	user_id INT,
	teacher_id INT,
	educational_prowess TINYINT,
	emotional_impact TINYINT,
	creativity_booster TINYINT,
	parents_interaction TINYINT,
	comment VARCHAR(200),
	PRIMARY KEY (id),
	FOREIGN KEY (user_id) REFERENCES users(id),
	FOREIGN KEY (teacher_id) REFERENCES teachers(id)
);

INSERT INTO schools(name, location_name, location_point) VALUES("Nicolae Iorga", "Bucuresti", POINT(44.4647054, 26.0702195));
INSERT INTO users(full_name) VALUES("Cristian Petroaca");
INSERT INTO teachers(full_name, school_id) VALUES("Maria Popescu", 1);
INSERT INTO ratings(user_id, teacher_id, educational_prowess, emotional_impact, creativity_booster, parents_interaction, comment) VALUES (1, 1, 5, 5, 5, 5, "Very good teacher");
UPDATE teachers SET overall_rating = 5 WHERE teachers.id = 1;

INSERT INTO teachers(full_name, school_id) VALUES("Elena Ionescu", 1);
INSERT INTO ratings(user_id, teacher_id, educational_prowess, emotional_impact, creativity_booster, parents_interaction, comment) VALUES (1, 2, 0, 0, 0, 0, "Very bad teacher");
UPDATE teachers SET overall_rating = 0 WHERE teachers.id = 2;

