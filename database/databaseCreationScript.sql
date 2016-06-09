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
  `UserID` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(32) NOT NULL,
  `LastName` VARCHAR(32) NOT NULL,
  `TeamId` BIGINT(11),
  `Email` VARCHAR(255) NOT NULL UNIQUE,
  `Password` VARCHAR(255) NOT NULL,
  `Login` VARCHAR(32),
  PRIMARY KEY (`UserID`)
);

DROP TABLE IF EXISTS `Java2_test`.`tasks` ;

CREATE TABLE IF NOT EXISTS `Java2_test`.`tasks` (
  `TaskID` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `DueDate` DATE,
  `DoneDate` DATE,
  `Title` VARCHAR(255),
  `Description` TEXT,
  `UserId` BIGINT(11),
  `ResponsibleId` BIGINT(11),
  `TaskType` CHAR(32),
  PRIMARY KEY (`TaskID`)
);

DROP TABLE IF EXISTS `Java2_test`.`teams` ;

CREATE TABLE IF NOT EXISTS `Java2_test`.`teams` (
  `TeamID` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(32) NOT NULL,
  `Description` TEXT,
  PRIMARY KEY (`TeamID`)
);

DROP TABLE IF EXISTS `Java2_test`.`task_types` ;

CREATE TABLE IF NOT EXISTS `Java2_test`.`task_types` (
  `TaskTypeID` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(32) NOT NULL,
  `Description` TEXT,
  `UserId` BIGINT(11),
  PRIMARY KEY (`TaskTypeID`)
);

DROP TABLE IF EXISTS `Java2_test`.`task_comments`;

CREATE TABLE IF NOT EXISTS `Java2_test`.`task_comments` (
  `CommentID` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `Text` TEXT,
  `CreateTimeStamp` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `TaskID` BIGINT(11) NOT NULL,
  `UserID` BIGINT(11) NOT NULL,
  PRIMARY KEY (`CommentID`)
);

ENGINE = InnoDB
AUTO_INCREMENT = 1002;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;