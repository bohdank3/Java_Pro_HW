INSERT INTO Homework (name, description) VALUES ('Homework 1', 'Description 1');
INSERT INTO Homework (name, description) VALUES ('Homework 2', 'Description 2');
INSERT INTO Homework (name, description) VALUES ('Homework 3', 'Description 3');

INSERT INTO Lesson (name, updatedAt, homework_id) VALUES ('Lesson 1', '2023-05-01 10:00:00', 1);
INSERT INTO Lesson (name, updatedAt, homework_id) VALUES ('Lesson 2', '2023-05-02 11:30:00', 2);
INSERT INTO Lesson (name, updatedAt, homework_id) VALUES ('Lesson 3', '2023-05-03 09:45:00', 3);

INSERT INTO Schedule (name, updatedAt) VALUES ('Schedule 1', '2023-05-01 10:00:00');
INSERT INTO Schedule (name, updatedAt) VALUES ('Schedule 2', '2023-05-02 11:30:00');
INSERT INTO Schedule (name, updatedAt) VALUES ('Schedule 3', '2023-05-03 09:45:00');

INSERT INTO Lesson_Schedule (lesson_id, schedule_id) VALUES (1, 1);
INSERT INTO Lesson_Schedule (lesson_id, schedule_id) VALUES (2, 2);
INSERT INTO Lesson_Schedule (lesson_id, schedule_id) VALUES (3, 3);