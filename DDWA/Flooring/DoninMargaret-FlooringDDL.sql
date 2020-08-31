DROP DATABASE IF EXISTS Flooring;
CREATE DATABASE Flooring;

USE Flooring;

CREATE TABLE `State` (
	`StateAbbreviation` CHAR(2) PRIMARY KEY,
    `Name` VARCHAR(25) NOT NULL,
    `TaxRate` DECIMAL(4,2) NOT NULL
);

CREATE TABLE `Product` (
	`ProductId` INT PRIMARY KEY AUTO_INCREMENT,
    `Type` VARCHAR(15) NOT NULL,
    `CostPerSquareFoot` DECIMAL(4,2) NOT NULL,
    `LaborPerSquareFoot` DECIMAL(4,2) NOT NULL
);

CREATE TABLE `Cost` (
	`CostId` INT PRIMARY KEY AUTO_INCREMENT,
    `MaterialCost` DECIMAL(7,2) NOT NULL,
    `LaborCost` DECIMAL(7,2) NOT NULL,
    `Tax` DECIMAL(6,2) NOT NULL,
    `Total` DECIMAL(8,2) NOT NULL
);

CREATE TABLE `Order` (
	`OrderId` INT PRIMARY KEY AUTO_INCREMENT,
    `Name` VARCHAR(20) NOT NULL,
    `Date` DATE NOT NULL,
    `StateAbbreviation` CHAR(2) NOT NULL,
    `ProductId` INT NOT NULL,
	`Area` DECIMAL(6,2) NOT NULL,
    `CostId` INT NOT NULL,
    
    FOREIGN KEY `fk_Order_State` (`StateAbbreviation`)
		REFERENCES `State`(`StateAbbreviation`),
	FOREIGN KEY `fk_Order_Product` (`ProductId`)
		REFERENCES `Product` (`ProductId`),
	FOREIGN KEY `fk_Order_Cost` (`CostId`)
		REFERENCES `Cost` (`CostId`)
);
