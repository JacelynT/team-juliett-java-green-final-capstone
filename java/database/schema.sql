BEGIN TRANSACTION;

DROP TABLE IF EXISTS child_book;
DROP TABLE IF EXISTS book_log;
DROP TABLE IF EXISTS library_book;
DROP TABLE IF EXISTS library;
DROP TABLE IF EXISTS active_book;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS child;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_library_id;
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

 CREATE SEQUENCE seq_library_id
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
	total_minutes int NOT NULL,
	
	CONSTRAINT PK_book PRIMARY KEY (isbn)
	
);
CREATE TABLE active_book (
        isbn varchar(50) NOT NULL,
	child_id int NOT NULL,
	
	CONSTRAINT FK_active_book_child FOREIGN KEY (child_id) REFERENCES child(child_id),
	CONSTRAINT FK_active_book_book FOREIGN KEY (isbn) REFERENCES book(isbn)
	
);
CREATE TABLE library_book (
        user_id int NOT NULL,
        isbn varchar(50) NOT NULL,
        
        CONSTRAINT FK_library_book_users FOREIGN KEY (user_id) REFERENCES users(user_id),
        CONSTRAINT FK_library_book_book FOREIGN KEY (isbn) REFERENCES book(isbn)
        
);
CREATE TABLE book_log (
        child_id int NOT NULL,
        isbn varchar(50) NOT NULL,
        minutes int NOT NULL,
        entry_date timestamp NOT NULL,
        entry_time time NOT NULL,
        
        CONSTRAINT FK_book_log_child FOREIGN KEY (child_id) REFERENCES child(child_id),
        CONSTRAINT FK_book_log_book FOREIGN KEY (isbn) REFERENCES book(isbn)
        
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


INSERT INTO child (child_name,user_id,icon_name) VALUES ('Gordon', 1,'dragon-solid.png');
INSERT INTO child (child_name,user_id,icon_name) VALUES ('Autumn', 1,'cat-solid.png');


INSERT INTO book (isbn,book_title,book_author, total_minutes) VALUES ('9780007158447','The Cat in the Hat','Dr. Seuss', 0);
INSERT INTO book (isbn,book_title,book_author, total_minutes) VALUES ('9780375810886','Green Eggs and Ham','Dr. Seuss', 0);
INSERT INTO book (isbn,book_title,book_author, total_minutes) VALUES ('9780439554923','Harry Potter and the Prisoner of Azkaban','J.K. Rowling', 0);
INSERT INTO book (isbn,book_title,book_author, total_minutes) VALUES ('9780439708180','Harry Potter and the Sorcerer''s Stone','J.K. Rowling', 0);
INSERT INTO book (isbn,book_title,book_author, total_minutes) VALUES ('9781728234939','How to Catch a Unicorn','Adam Wallace', 0);
INSERT INTO book (isbn,book_title,book_author, total_minutes) VALUES ('9780007413577','Oh, the Places You''ll Go','Dr. Seuss', 0);
INSERT INTO book (isbn,book_title,book_author, total_minutes) VALUES ('9780670016617','The Last Kids on Earth','Max Brallier', 0);
INSERT INTO book (isbn,book_title,book_author, total_minutes) VALUES ('9780140371567','James and the Giant Peach','Roald Dahl', 0);
INSERT INTO book (isbn,book_title,book_author, total_minutes) VALUES ('9780440840404','The BFG','Roald Dahl', 0);
INSERT INTO book (isbn,book_title,book_author, total_minutes) VALUES ('9780439064873','Harry Potter and the Chamber of Secrets','J.K. Rowling', 0);
INSERT INTO book (isbn,book_title,book_author, total_minutes) VALUES ('9781452106557','Darth Vader and Son','Jeffrey Brown', 0);
INSERT INTO book (isbn,book_title,book_author, total_minutes) VALUES ('9780140367416','Anne of Green Gables','L.M. Montgomery', 0);
INSERT INTO book (isbn,book_title,book_author, total_minutes) VALUES ('9780001831520','The Lion, the Witch, and the Wardrobe','C.S. Lewis', 0);
INSERT INTO book (isbn,book_title,book_author, total_minutes) VALUES ('9780194227230','Alice''s Adventures in Wonderland','Lewis Carol', 0);
INSERT INTO book (isbn,book_title,book_author, total_minutes) VALUES ('9780399255373','The Day the Crayons Quit','Drew Daywalt', 0);
INSERT INTO book (isbn,book_title,book_author, total_minutes) VALUES ('9780399172755','The Day the Crayons Came Home','Drew Daywalt', 0);
INSERT INTO book (isbn,book_title,book_author, total_minutes) VALUES ('9781492662471','How to Catch a Mermaid','Adam Wallace', 0);
INSERT INTO book (isbn,book_title,book_author, total_minutes) VALUES ('9780803736801','Dragons Love Tacos','Adam Rubin', 0);
INSERT INTO book (isbn,book_title,book_author, total_minutes) VALUES ('9780525428886','Dragons Love Tacos 2: The Sequel','Adam Rubin', 0);
INSERT INTO book (isbn,book_title,book_author, total_minutes) VALUES ('9781732596344','The Magic of Me, My Magical Words','Becky Cummings', 0);
INSERT INTO book (isbn,book_title,book_author, total_minutes) VALUES ('9780060207052','Goodnight Moon','Margaret Wise Brown', 0);
INSERT INTO book (isbn,book_title,book_author, total_minutes) VALUES ('9780312850098','The Wheel of Time: The Eye of the World','Robert Jordan', 0);
INSERT INTO book (isbn,book_title,book_author, total_minutes) VALUES ('9781557091444','The Tower Treasure: Hardy Boys Book 1','Franklin W. Dixon', 0);


INSERT INTO book_log (isbn,child_id,minutes,entry_date, entry_time) VALUES ('9780439708180',2,30,'2021-12-08', '01:14:07');
INSERT INTO book_log (isbn,child_id,minutes,entry_date, entry_time) VALUES ('9780375810886',2,30,'2021-12-09', '02:14:07');
INSERT INTO book_log (isbn,child_id,minutes,entry_date, entry_time) VALUES ('9780439064873',1,60,'2021-12-08', '03:14:07');
INSERT INTO book_log (isbn,child_id,minutes,entry_date, entry_time) VALUES ('9780440840404',1,50,'2021-12-09', '04:14:07');
INSERT INTO book_log (isbn,child_id,minutes,entry_date, entry_time) VALUES ('9780007158447',2,30,'2021-12-06', '05:14:07');
INSERT INTO book_log (isbn,child_id,minutes,entry_date, entry_time) VALUES ('9780375810886',2,20,'2021-12-07', '06:14:07');
INSERT INTO book_log (isbn,child_id,minutes,entry_date, entry_time) VALUES ('9780439554923',1,60,'2021-12-06', '07:14:07');
INSERT INTO book_log (isbn,child_id,minutes,entry_date, entry_time) VALUES ('9780439708180',1,30,'2021-12-07', '08:14:07');
INSERT INTO book_log (isbn,child_id,minutes,entry_date, entry_time) VALUES ('9780007158447',2,20,'2021-12-04', '09:14:07');
INSERT INTO book_log (isbn,child_id,minutes,entry_date, entry_time) VALUES ('9780007158447',2,30,'2021-12-05', '10:14:07');
INSERT INTO book_log (isbn,child_id,minutes,entry_date, entry_time) VALUES ('9780375810886',2,20,'2021-12-04', '11:14:07');
INSERT INTO book_log (isbn,child_id,minutes,entry_date, entry_time) VALUES ('9780439554923',1,60,'2021-12-05', '12:14:07');
INSERT INTO book_log (isbn,child_id,minutes,entry_date, entry_time) VALUES ('9780439708180',1,30,'2021-12-01', '01:14:07');
INSERT INTO book_log (isbn,child_id,minutes,entry_date, entry_time) VALUES ('9780007158447',2,20,'2021-12-04', '02:14:07');
INSERT INTO book_log (isbn,child_id,minutes,entry_date, entry_time) VALUES ('9780670016617',2,40,'2021-12-03', '03:14:07');
INSERT INTO book_log (isbn,child_id,minutes,entry_date, entry_time) VALUES ('9781728234939',1,60,'2021-12-02', '04:14:07');
INSERT INTO book_log (isbn,child_id,minutes,entry_date, entry_time) VALUES ('9780439554923',1,40,'2021-12-03', '05:14:07');
INSERT INTO book_log (isbn,child_id,minutes,entry_date, entry_time) VALUES ('9780140371567',2,50,'2021-12-03', '06:14:07');
INSERT INTO book_log (isbn,child_id,minutes,entry_date, entry_time) VALUES ('9780375810886',2,30,'2021-12-02', '07:14:07');
INSERT INTO book_log (isbn,child_id,minutes,entry_date, entry_time) VALUES ('9780007413577',1,60,'2021-12-05', '08:14:07');
INSERT INTO book_log (isbn,child_id,minutes,entry_date, entry_time) VALUES ('9780439554923',1,20,'2021-12-01', '09:14:07');
INSERT INTO book_log (isbn,child_id,minutes,entry_date, entry_time) VALUES ('9780439708180',2,30,'2021-12-02', '10:14:07');
INSERT INTO book_log (isbn,child_id,minutes,entry_date, entry_time) VALUES ('9780375810886',2,30,'2021-12-01', '11:14:07');
INSERT INTO book_log (isbn,child_id,minutes,entry_date, entry_time) VALUES ('9780439064873',1,60,'2021-12-05', '12:14:07');
INSERT INTO book_log (isbn,child_id,minutes,entry_date, entry_time) VALUES ('9780440840404',1,50,'2021-12-01', '01:14:07');



INSERT INTO library_book (isbn,user_id) VALUES ('9780007158447', 1);
INSERT INTO library_book (isbn,user_id) VALUES ('9780375810886', 1);
INSERT INTO library_book (isbn,user_id) VALUES ('9780439554923', 1);
INSERT INTO library_book (isbn,user_id) VALUES ('9780439708180', 1);
INSERT INTO library_book (isbn,user_id) VALUES ('9781728234939', 1);
INSERT INTO library_book (isbn,user_id) VALUES ('9780007413577', 1);
INSERT INTO library_book (isbn,user_id) VALUES ('9780670016617', 1);
INSERT INTO library_book (isbn,user_id) VALUES ('9780140371567', 1);
INSERT INTO library_book (isbn,user_id) VALUES ('9780440840404', 1);
INSERT INTO library_book (isbn,user_id) VALUES ('9780439064873', 1);
INSERT INTO library_book (isbn,user_id) VALUES ('9781452106557', 1);
INSERT INTO library_book (isbn,user_id) VALUES ('9780140367416', 1);
INSERT INTO library_book (isbn,user_id) VALUES ('9780001831520', 1);
INSERT INTO library_book (isbn,user_id) VALUES ('9780194227230', 1);
INSERT INTO library_book (isbn,user_id) VALUES ('9780399255373', 1);
INSERT INTO library_book (isbn,user_id) VALUES ('9780399172755', 1);
INSERT INTO library_book (isbn,user_id) VALUES ('9781492662471', 1);
INSERT INTO library_book (isbn,user_id) VALUES ('9780803736801', 1);
INSERT INTO library_book (isbn,user_id) VALUES ('9780525428886', 1);
INSERT INTO library_book (isbn,user_id) VALUES ('9781732596344', 1);
INSERT INTO library_book (isbn,user_id) VALUES ('9780060207052', 1);
INSERT INTO library_book (isbn,user_id) VALUES ('9780312850098', 1);
INSERT INTO library_book (isbn,user_id) VALUES ('9781557091444', 1);


INSERT INTO active_book (isbn, child_id) VALUES ('9780007158447', 1);
INSERT INTO active_book (isbn, child_id) VALUES ('9780439554923', 1);
INSERT INTO active_book (isbn, child_id) VALUES ('9780670016617', 1);
INSERT INTO active_book (isbn, child_id) VALUES ('9780007158447', 2);
INSERT INTO active_book (isbn, child_id) VALUES ('9780375810886', 2);
INSERT INTO active_book (isbn, child_id) VALUES ('9780439064873', 2);


COMMIT TRANSACTION;
