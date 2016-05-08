SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `Java2_test` DEFAULT CHARACTER SET utf8 ;
USE `Java2_test` ;

-- -----------------------------------------------------
-- Table `Java2_test`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Java2_test`.`users` ;

CREATE TABLE IF NOT EXISTS `Java2_test`.`users` (
  `UserID` INT(11) NOT NULL AUTO_INCREMENT,
  `FirstName` CHAR(32) NOT NULL,
  `LastName` CHAR(32) NOT NULL,
  `TeamId` INT(11),
  `Email` VARCHAR(255) NOT NULL UNIQUE,
  `Password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`UserID`)
);

INSERT INTO `Java2_test`.`users` (FirstName, LastName, Email, Password)
VALUES ('UserName', 'UserLastName', '1user@email.com', '12345');

DROP TABLE IF EXISTS `Java2_test`.`tasks` ;

CREATE TABLE IF NOT EXISTS `Java2_test`.`tasks` (
  `TaskID` INT(11) NOT NULL AUTO_INCREMENT,
  `DueDatetime` DATETIME,
  `DoneDate` DATE,
  `Title` VARCHAR(255),
  `Description` TEXT,
  `UserId` INT(11),
  `ResponsibleId` INT(11),
  `TaskType` CHAR(32),
  PRIMARY KEY (`TaskID`)
);

INSERT INTO `Java2_test`.`tasks` (Title, TaskType, Description, DoneDate, DueDatetime, UserId, ResponsibleId) VALUES ("Task title 1", "Email", "Description1", "2016-05-01", "2016-05-01 10:00:00", 1, 1);
INSERT INTO `Java2_test`.`tasks` (Title, TaskType, Description, DueDatetime, UserId, ResponsibleId) VALUES ("Task title 2", "Phone call", "Description2", "2016-05-01 11:00:00", 1, 1);

DROP TABLE IF EXISTS `Java2_test`.`teams` ;

CREATE TABLE IF NOT EXISTS `Java2_test`.`teams` (
  `TeamID` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(32) NOT NULL,
  `Description` TEXT,
  PRIMARY KEY (`TeamID`)
);


INSERT INTO `Java2_test`.`teams` (Name, Description) VALUES ("Test team Nr 1", "Description of test team nr 1");
INSERT INTO `Java2_test`.`teams` (Name, Description) VALUES ("Test team Nr 2", "Description of test team nr 2");
INSERT INTO `Java2_test`.`teams` (Name, Description) VALUES ("Test team Nr 3", "Description of test team nr 3");

DROP TABLE IF EXISTS `Java2_test`.`task_types` ;

CREATE TABLE IF NOT EXISTS `Java2_test`.`task_types` (
  `TaskTypeID` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(32) NOT NULL,
  `Description` TEXT,
  `UserId` INT(11),
  PRIMARY KEY (`TaskTypeID`)
);

INSERT INTO task_types (Name) VALUES ("Email");
INSERT INTO task_types (Name) VALUES ("Phone call");
INSERT INTO task_types (Name) VALUES ("Meeting");

ENGINE = InnoDB
AUTO_INCREMENT = 1002;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;