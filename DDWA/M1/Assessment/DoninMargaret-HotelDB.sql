-- Created by: Margaret Donin
-- Date created: 08/05/20
-- Date revised:

DROP DATABASE IF EXISTS HotelSoftwareGuild;

CREATE DATABASE HotelSoftwareGuild;
USE HotelSoftwareGuild;

CREATE TABLE IF NOT EXISTS `Guest` (
	`GuestId` INT PRIMARY KEY AUTO_INCREMENT,
    `FirstName` VARCHAR(50) NOT NULL,
    `LastName` VARCHAR(50) NOT NULL,
    `Address` VARCHAR(100) NOT NULL,
    `City` VARCHAR(50) NOT NULL,
    `State` CHAR(2) NOT NULL,
    `Zip` CHAR(5) NOT NULL,
    `Phone` VARCHAR(15) NOT NULL
);

CREATE TABLE IF NOT EXISTS `Amenity` (
	`AmenityId` INT PRIMARY KEY AUTO_INCREMENT,
    `Name` VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS `RoomType` (
	`RoomTypeId` INT PRIMARY KEY AUTO_INCREMENT,
    `Name` VARCHAR(10) NOT NULL,
    `StandardOccupancy` TINYINT NOT NULL,
    `MaximumOccupancy` TINYINT NOT NULL,
    `BasePrice` DECIMAL(6,2) NOT NULL,
    `ExtraPerson` DECIMAL(4,2) NULL
);

CREATE TABLE IF NOT EXISTS `Room` (
	`RoomId` INT PRIMARY KEY,
    `RoomTypeId` INT NOT NULL,
    `AdaAccessible` BOOL NOT NULL,
     
	FOREIGN KEY `fk_Room_RoomType` (`RoomTypeId`)
		REFERENCES `RoomType` (`RoomTypeId`)
);

CREATE TABLE IF NOT EXISTS `RoomAmenity` (
	`RoomId` INT NOT NULL,
    `AmenityId` INT NOT NULL,

	PRIMARY KEY `pk_RoomAmenity` (`RoomId`, `AmenityId`),

	FOREIGN KEY `fk_RoomAmenity_RoomId` (`RoomId`)
		REFERENCES `Room` (`RoomId`),
	FOREIGN KEY `fk_RoomAmenity_Amenity` (`AmenityId`)
		REFERENCES `Amenity` (`AmenityId`)
);

CREATE TABLE IF NOT EXISTS `RESERVATION` (
	`ReservationId` INT PRIMARY KEY AUTO_INCREMENT,
    `GuestId` INT NOT NULL,
    `Adult` TINYINT NOT NULL,
    `Children` TINYINT NOT NULL,
    `Start` DATE NOT NULL,
    `End` DATE NOT NULL,
    `RoomId` INT NOT NULL,
    `Price` DECIMAL(6,2) NOT NULL,

	FOREIGN KEY `fk_Reservation_GuestId` (`GuestId`)
		REFERENCES `Guest` (`GuestId`),
	FOREIGN KEY `fk_Reservation_Room` (`RoomId`)
		REFERENCES `Room` (`RoomId`)
);