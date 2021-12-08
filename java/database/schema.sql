BEGIN TRANSACTION;

DROP TABLE IF EXISTS child_book;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS child;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_child_book_id;
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

 CREATE SEQUENCE seq_child_book_id
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
CREATE TABLE book (
	isbn varchar(50) NOT NULL,
	book_title varchar(50) NOT NULL,
	book_author varchar(50) NOT NULL,
	CONSTRAINT PK_book PRIMARY KEY (isbn)
);
CREATE TABLE child_book (
    child_book_id int DEFAULT nextval('seq_child_book_id'::regclass) NOT NULL,
    isbn varchar(50) NOT NULL,
	child_id int NOT NULL,
	minutes int NOT NULL,
	entry_date date NOT NULL,
	CONSTRAINT PK_child_book PRIMARY KEY (child_book_id),
	CONSTRAINT FK_child_book_child FOREIGN KEY (child_id) REFERENCES child(child_id),
	CONSTRAINT FK_child_book_book FOREIGN KEY (isbn) REFERENCES book(isbn)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO child (child_name,user_id,icon_name) VALUES ('Gordon',1,'face-icon.jpg');
INSERT INTO child (child_name,user_id,icon_name) VALUES ('Autumn', 1,'face-icon.jpg');

INSERT INTO book (isbn,book_title,book_author) VALUES ('9780007158447','The Cat in the Hat','Dr. Seuss');
INSERT INTO book (isbn,book_title,book_author) VALUES ('9780375810886','Green Eggs and Ham','Dr. Seuss');
INSERT INTO book (isbn,book_title,book_author) VALUES ('9780439554923','Harry Potter and the Prisoner of Azkaban','J.K. Rowling');
INSERT INTO book (isbn,book_title,book_author) VALUES ('9780439708180','Harry Potter and the Sorcerer''s Stone','J.K. Rowling');
INSERT INTO book (isbn,book_title,book_author) VALUES ('9781728234939','How to Catch a Unicorn','Adam Wallace');
INSERT INTO book (isbn,book_title,book_author) VALUES ('9780007413577','Oh, the Places You''ll Go','Dr. Seuss');
INSERT INTO book (isbn,book_title,book_author) VALUES ('9780670016617','The Last Kids on Earth','Max Brallier');
INSERT INTO book (isbn,book_title,book_author) VALUES ('9780140371567','James and the Giant Peach','Roald Dahl');
INSERT INTO book (isbn,book_title,book_author) VALUES ('9780440840404','The BFG','Roald Dahl');
INSERT INTO book (isbn,book_title,book_author) VALUES ('9780439064873','Harry Potter and the Chamber of Secrets','J.K. Rowling');




INSERT INTO child_book (isbn,child_id,minutes,entry_date) VALUES ('9780007158447',2,30,'2021-12-05');
INSERT INTO child_book (isbn,child_id,minutes,entry_date) VALUES ('9780375810886',2,30,'2021-12-05');
INSERT INTO child_book (isbn,child_id,minutes,entry_date) VALUES ('9780439554923',1,60,'2021-12-05');
INSERT INTO child_book (isbn,child_id,minutes,entry_date) VALUES ('9780439554923',1,45,'2021-12-01');

COMMIT TRANSACTION;
