CREATE TABLE IF NOT EXISTS user (
  id          INTEGER PRIMARY KEY AUTO_INCREMENT,
  email VARCHAR(64) NOT NULL);

CREATE TABLE IF NOT EXISTS user_data (
  id          INTEGER PRIMARY KEY AUTO_INCREMENT,
  id_user     INTEGER,
  name        VARCHAR(64) NOT NULL,
  lastname    VARCHAR(64) NOT NULL);

CREATE TABLE IF NOT EXISTS loan (
  id          INTEGER PRIMARY KEY AUTO_INCREMENT,
  id_user     INTEGER,
  total       FLOAT);