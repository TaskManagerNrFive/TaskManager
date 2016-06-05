
INSERT INTO `Java2_test`.`users` (FirstName, LastName, TeamId, Email, Login, Password)
VALUES ('Andrey', 'Maksimov', 1, 'andrey@email.com', 'andmak', '12345');

INSERT INTO `Java2_test`.`users` (FirstName, LastName, TeamId, Email, Login, Password)
VALUES ('Ivan', 'Ivanov', 2, 'ivan@email.com', 'ivaiva', '12345');

INSERT INTO `Java2_test`.`users` (FirstName, LastName, TeamId, Email, Login, Password)
VALUES ('Oleg', 'Izvekov', 2, 'oleizv@email.com', 'oleizv', '12345');

INSERT INTO `Java2_test`.`users` (FirstName, LastName, TeamId, Email, Login, Password)
VALUES ('Dmitry', 'Volkov', 2, 'dmitry@email.com', 'dmivol', '32401');

INSERT INTO `Java2_test`.`users` (FirstName, LastName, TeamId, Email, Login, Password)
VALUES ('Viktor', 'Sokolov', 3, 'viksol@email.com', 'viksol', '32401');

INSERT INTO `Java2_test`.`tasks` (Title, TaskType, Description, DoneDate, DueDate, UserId, ResponsibleId)
VALUES ("Task title 1", "Email", "Description1", "2016-05-01", "2016-05-01", 1, 1);
INSERT INTO `Java2_test`.`tasks` (Title, TaskType, Description, DueDate, UserId, ResponsibleId)
VALUES ("Task title 2", "Phone call", "Description2", "2016-05-01", 1, 1);

INSERT INTO `Java2_test`.`tasks` (Title, TaskType, Description, DoneDate, DueDate, UserId, ResponsibleId)
VALUES ("Great task", "Phone call", "Description3", "2016-05-16", "2016-05-20", 2, 2);
INSERT INTO `Java2_test`.`tasks` (Title, TaskType, Description, DueDate, UserId, ResponsibleId)
VALUES ("Great task", "Phone call", "Description3", "2016-04-15", 2, 2);
INSERT INTO `Java2_test`.`tasks` (Title, TaskType, Description, DoneDate, DueDate, UserId, ResponsibleId)
VALUES ("Hard task", "Phone call", "Description3", "2016-05-16", "2016-05-20", 3, 3);
INSERT INTO `Java2_test`.`tasks` (Title, TaskType, Description, DoneDate, DueDate, UserId, ResponsibleId)
VALUES ("Hard task", "Phone call", "Description3", "2016-04-10", "2016-04-15", 3, 3);

INSERT INTO `Java2_test`.`tasks` (Title, TaskType, Description, DueDate, UserId, ResponsibleId)
VALUES ("0505 task", "Phone call", "Description3", "2016-05-20", 5, 5);

INSERT INTO `Java2_test`.`teams` (Name, Description) VALUES ("Test team Nr 1", "Description of test team nr 1");
INSERT INTO `Java2_test`.`teams` (Name, Description) VALUES ("Test team Nr 2", "Description of test team nr 2");
INSERT INTO `Java2_test`.`teams` (Name, Description) VALUES ("Test team Nr 3", "Description of test team nr 3");

INSERT INTO task_types (Name, UserId) VALUES ("Email", 1);
INSERT INTO task_types (Name, UserId) VALUES ("Phone call", 1);
INSERT INTO task_types (Name, UserId) VALUES ("Meeting", 1);

INSERT INTO `Java2_test`.`task_comments` (Text, TaskID, UserID)
VALUES ("Great task!\nAwesome!", 1, 2);
INSERT INTO `Java2_test`.`task_comments` (Text, TaskID, UserID)
VALUES ("Test test Test test Test test Test test1! \n         Test test Test test Test test2!", 1, 3);
