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
(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
,username VARCHAR(250) NOT NULL
,password VARCHAR(250) NOT NULL
,role VARCHAR(20) NOT NULL);

INSERT INTO genre (name) VALUES ('Rock'), ('Pop'), ('Heavy'), ('Jazz'), ('Folk');

INSERT INTO song (songkey, name, original_performer, total_length, genreid) 
VALUES ('Am', 'Screaming for Vengeance', 'Judas Priest', '5:34', 3), 
('G', 'Every Breath You take', 'The Police', '3:25', 1);

INSERT INTO gig (comment, location, pvm)
VALUES ('Birthday party', 'Helsinki', '2019-11-21 18:15:00.000'),
('Wedding', 'Turku', '2019-11-29 12:00:00.000');

INSERT INTO user (username, password, role) 
VALUES ("user", "$2a$10$1DTvwpXVBArGFixHBuzVJObjTuXhIOkx5pse6KsYs8/C2ckxnGEou", "USER"), 
("admin", "$2a$10$cDZgyF4xaPMmmoRW3OVcmuf.8o2YSx8.M7CeRKqi.1PVw.t3E8uEC", "ADMIN");
