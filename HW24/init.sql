-- Створення таблиці Homework
CREATE TABLE Homework (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  description TEXT
);

-- Створення таблиці Lesson
CREATE TABLE Lesson (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  updatedAt DATETIME,
  homework_id INT,
  FOREIGN KEY (homework_id) REFERENCES Homework(id)
);

-- Створення таблиці Schedule
CREATE TABLE Schedule (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  updatedAt DATETIME
);

-- Створення таблиці-зв'язку для зв'язку багато-до-багатьох між таблицями Schedule і Lesson
CREATE TABLE Schedule_Lesson (
  schedule_id INT,
  lesson_id INT,
  FOREIGN KEY (schedule_id) REFERENCES Schedule(id),
  FOREIGN KEY (lesson_id) REFERENCES Lesson(id),
  PRIMARY KEY (schedule_id, lesson_id)
);