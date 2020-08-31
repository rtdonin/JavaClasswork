DROP DATABASE IF EXISTS BullsCowsDB;
CREATE DATABASE BullsCowsDB;

USE BullsCowsDB;

CREATE TABLE `Game` (
	`gameId` INT PRIMARY KEY AUTO_INCREMENT,
    `answer` CHAR(4) NOT NULL,
    `isFinished` BOOL DEFAULT FALSE NOT NULL
);

CREATE TABLE `Attempt` (
	`attemptId` INT PRIMARY KEY AUTO_INCREMENT,
    `gameId` INT NOT NULL,
    `guess` CHAR(4) NOT NULL,
	`score` CHAR(7) NOT NULL,
    `time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    
    FOREIGN KEY `fk_Attempt_Game` (`gameId`)
        REFERENCES `Game` (`gameId`)
);