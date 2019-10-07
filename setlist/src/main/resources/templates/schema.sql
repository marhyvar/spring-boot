DROP TABLE genre;
DROP TABLE gig;
DROP TABLE song;
DROP TABLE user;

CREATE TABLE genre 
(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
,name VARCHAR(50) NOT NULL);

CREATE TABLE gig
(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, comment VARCHAR(40) NOT NULL,
location VARCHAR(40) NOT NULL, 
pvm TIMESTAMP not null);

CREATE TABLE song 
(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
songkey VARCHAR(5) NOT NULL, 
name VARCHAR(255) NOT NULL, 
original_performer VARCHAR(30) NOT NULL,
total_length VARCHAR(255) NOT NULL,
genreid BIGINT NOT NULL);

CREATE TABLE user
(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
password VARCHAR(255) NOT NULL,
role VARCHAR(255) NOT NULL,
username VARCHAR(255) NOT NULL);

INSERT INTO genre (name) VALUES ('Rock'), ('Pop'), ('Heavy');

INSERT INTO song (songkey, name, original_performer, total_length, genreid) 
VALUES ('Am', 'Screaming for Vengeance', 'Judas Priest', '5:34', 3), 
('G', 'Every Breath You take', 'The Police', '3:25', 1);

INSERT INTO gig (comment, location, pvm)
VALUES ('Birthday party', 'Helsinki', '2019-11-21 18:15:00.000'),
('Wedding', 'Turku', '2019-11-29 12:00:00.000');

INSERT INTO user (password, role, username)
VALUES ('$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 'USER', 'user'),
('$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C', 'ADMIN', 'admin');
