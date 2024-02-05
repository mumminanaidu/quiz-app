

# Quiz App

Welcome to the Quiz App repository! This Spring Boot project designed for creating and managing quizzes. It utilizes PostgreSQL as the backend database.

## Setup Instructions

To get started with the Quiz App, follow these steps:

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/quiz-app.git
   ```

2. **Database Configuration:**
   - Ensure you have PostgreSQL installed and running.
   - Create a database named `quiz_app`.
   - Set your database credentials in `application.properties`.

3. **Build and Run:**
   ```bash
   mvn clean install
   java -jar target/quiz-app.jar
   ```

## Database Initialization

You can initialize the database with sample quiz questions using the following SQL query:

```sql
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES
  ('What is the default value of byte data type in Java?', '0', '1', 'null', '-1', '0', 'Easy', 'Java'),
  ('Which keyword is used to define a constant in Java?', 'final', 'const', 'static', 'int', 'final', 'Easy', 'Java'),
  ('What is the output of 2 + 5 * 3 in Java?', '21', '17', '23', '16', '21', 'Medium', 'Java'),
  ('What is the purpose of the 'break' statement in Java?', 'To terminate the loop or switch statement', 'To skip the current iteration of a loop', 'To jump out of a method', 'To return a value from a method', 'To terminate the loop or switch statement', 'Medium', 'Java'),
  ('Which data type is used to represent a single character in Java?', 'char', 'string', 'byte', 'int', 'char', 'Easy', 'Java'),
  ('What is the output of the following code snippet? \n int x = 5; \n System.out.println(x++);', '5', '6', '4', 'Compilation Error', '5', 'Easy', 'Java'),
  ('In Java, what is the purpose of the 'super' keyword?', 'To refer to the superclass or parent class', 'To invoke a method of the superclass', 'To create an object of the superclass', 'To access the instance variables of the superclass', 'To refer to the superclass or parent class', 'Medium', 'Java'),
  ('Which of the following is not a valid keyword in Java?', 'goto', 'enum', 'implements', 'interface', 'goto', 'Medium', 'Java'),
  ('What is the output of the following code snippet? \n String s1 = "hello"; \n String s2 = "hello"; \n System.out.println(s1 == s2);', 'true', 'false', 'Compilation Error', 'null', 'true', 'Easy', 'Java'),

  ('What is the keyword used for creating a package in Java?', 'package', 'import', 'namespace', 'create', 'package', 'Easy', 'Java'),

  ('What is the primary purpose of the 'finally' block in Java?', 'To ensure a block of code always executes, whether an exception is thrown or not', 'To handle exceptions', 'To terminate a program', 'To skip a block of code', 'To ensure a block of code always executes, whether an exception is thrown or not', 'Hard', 'Java'),

  ('Which of the following is a valid declaration of a two-dimensional array in Java?', 'int[][] array2D;', 'int[2][2] array;', 'int array2D[2][2];', 'int array2D[][];', 'int[][] array2D;', 'Medium', 'Java'),

  ('In Java, what is the role of the 'this' keyword?', 'To refer to the current instance of the class', 'To invoke a method of another class', 'To create a new instance of the class', 'To access a static variable', 'To refer to the current instance of the class', 'Easy', 'Java'),

  ('Which method is used to compare two strings in Java for equality?', 'equals()', 'compareTo()', 'compare()', 'isEqual()', 'equals()', 'Easy', 'Java'),

  ('What is the purpose of the 'volatile' keyword in Java?', 'To indicate that a variable may be modified by multiple threads', 'To make a variable constant', 'To define a constant variable', 'To prevent variable modification', 'To indicate that a variable may be modified by multiple threads', 'Medium', 'Java'),

  -- Python Questions
  ('What is the syntax for defining a function in Python?', 'def function_name():', 'function function_name():', 'define function_name():', 'fn function_name():', 'def function_name():', 'Easy', 'Python'),
  ('How do you comment multiple lines in Python?', ''''', '/* */', '##', '//', '''''', 'Easy', 'Python'),
  ('What is the purpose of the 'elif' keyword in Python?', 'To check multiple conditions after the 'if' statement', 'To create a new function', 'To handle exceptions', 'To terminate a loop', 'To check multiple conditions after the 'if' statement', 'Medium', 'Python'),
  ('In Python, how do you open a file in binary mode?', 'open('file.bin', 'rb')', 'open('file.bin', 'r')', 'open('file.bin', 'wb')', 'open('file.bin', 'w')', 'open('file.bin', 'rb')', 'Medium', 'Python'),
  ('What is the output of the following code? \n x = [1, 2, 3] \n print(x[0])', '1', '2', '3', 'IndexError', '1', 'Easy', 'Python'),
  ('What is the purpose of the 'self' parameter in Python class methods?', 'To refer to the instance of the class', 'To invoke a method of another class', 'To create a new instance of the class', 'To access a static variable', 'To refer to the instance of the class', 'Hard', 'Python'),
  ('How do you define an empty set in Python?', 'empty_set = set()', 'empty_set = {}', 'empty_set = set([])', 'empty_set = []', 'empty_set = set()', 'Easy', 'Python'),
  ('In Python, what is the purpose of the 'pass' statement?', 'To create an infinite loop', 'To skip the current iteration of a loop', 'To terminate a loop', 'To do nothing and act as a placeholder', 'To do nothing and act as a placeholder', 'Medium', 'Python'),
  ('Which of the following is a valid way to create a dictionary in Python?', 'my_dict = dict(key1=value1, key2=value2)', 'my_dict = {key1:value1, key2:value2}', 'my_dict = [(key1, value1), (key2, value2)]', 'my_dict = {}', 'my_dict = {key1:value1, key2:value2}', 'Easy', 'Python'),
  ('What is the purpose of the 'break' statement in a loop in Python?', 'To terminate the loop', 'To skip the current iteration of the loop', 'To create an infinite loop', 'To continue to the next iteration of the loop', 'To terminate the loop', 'Easy', 'Python');

```

```sql
select id, right_answer from question
where id=7 or id=3 or id=12 or id=14 or id=9

```
## Postman Collection

To interact with the Quiz App's APIs, you can use the provided Postman collection. Import the collection using the following link:

[Quiz App Postman Collection]()

## References

- [ YouTube Video ](https://youtu.be/vlz9ina4Usk) - This project was created based on the instructions provided in this YouTube video.

