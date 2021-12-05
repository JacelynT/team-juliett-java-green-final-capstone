BEGIN TRANSACTION;

DROP TABLE IF EXISTS child;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_child_id;
DROP SEQUENCE IF EXISTS seq_user_id;



CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE SEQUENCE seq_child_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE TABLE child (
	child_id int DEFAULT nextval('seq_child_id'::regclass) NOT NULL,
	child_name varchar(50) NOT NULL,
	user_id int NOT NULL,
	icon_name varchar(50) NOT NULL,
	CONSTRAINT PK_child PRIMARY KEY (child_id),
	CONSTRAINT FK_child_users FOREIGN KEY (user_id) REFERENCES users(user_id)
	
);




INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


COMMIT TRANSACTION;
