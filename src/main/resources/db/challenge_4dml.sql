CREATE SEQUENCE  IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE users (
  id INTEGER NOT NULL,
   username VARCHAR(255) NOT NULL,
   email VARCHAR(255) NOT NULL,
   password VARCHAR(255),
   CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE users ADD CONSTRAINT uc_users_username UNIQUE (username);

CREATE TABLE films (
  film_code INTEGER NOT NULL,
   film_name VARCHAR(255) NOT NULL,
   is_playing BOOLEAN NOT NULL,
   CONSTRAINT pk_films PRIMARY KEY (film_code)
);

ALTER TABLE films ADD CONSTRAINT uc_films_film_code UNIQUE (film_code);

ALTER TABLE films ADD CONSTRAINT uc_films_film_name UNIQUE (film_name);

CREATE TABLE seats (
  seat_number INTEGER,
   studio_name VARCHAR(255),
   status VARCHAR(255),
   seats_id INTEGER NOT NULL,
   CONSTRAINT pk_seats PRIMARY KEY (seats_id)
);

CREATE TABLE schedules (
  schedule_id INTEGER NOT NULL,
   film_code INTEGER,
   playing_date VARCHAR(255),
   starting_time VARCHAR(255),
   ending_time VARCHAR(255),
   ticket_price INTEGER,
   list_film INTEGER,
   CONSTRAINT pk_schedules PRIMARY KEY (schedule_id)
);

ALTER TABLE schedules ADD CONSTRAINT FK_SCHEDULES_ON_LIST_FILM FOREIGN KEY (list_film) REFERENCES films (film_code);

insert into users (id, username, email, password)
values (101, 'leona', 'leona@gmail.com', 'leonaajah123'),
(102, 'jokowi', 'jokowi@gmail.com', 'jokowiajah123');

insert into films (film_code, film_name, is_playing)
values (1001, 'Attack on Weebs', TRUE),
(1002, 'Waifu Wars', TRUE),
(1003, 'Isekai Jokowi', TRUE),
(1004, 'Daily Life of Puan-Chan', TRUE);

insert into schedules (schedule_id, film_code, playing_date, starting_time, ending_time, ticket_price)
values (1010, 1001, '01 November 2022', '12:00', '15:00', 50000),
(1020, 1001, '03 November 2022', '16:00', '19:00', 50000),
(1030, 1002, '01 November 2022', '12:00', '15:00', 50000),
(1040, 1002, '03 November 2022', '16:00', '19:00', 50000),
(1050, 1003, '01 November 2022', '12:00', '15:00', 50000),
(1060, 1003, '03 November 2022', '16:00', '19:00', 50000),
(1070, 1004, '01 November 2022', '12:00', '15:00', 50000),
(1080, 1004, '03 November 2022', '16:00', '19:00', 50000);

insert into seats (seats_id, seat_number, studio_name, status)
values (1, 1, 'A', 'Available'),
(2, 2, 'A', 'Available'),
(3, 1, 'B', 'Available'),
(4, 2, 'B', 'Available'),
(5, 1, 'C', 'Available'),
(6, 2, 'C', 'Available');