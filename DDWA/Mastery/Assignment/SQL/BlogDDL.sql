DROP DATABASE IF EXISTS `BlogDB`;
CREATE DATABASE `BlogDB`;

USE `BlogDB`;

CREATE TABLE `Role`(
	`roleId`	INT PRIMARY KEY AUTO_INCREMENT,
    `name`		VARCHAR(13) NOT NULL
);

CREATE TABLE `User`(
	`userId`	INT PRIMARY KEY AUTO_INCREMENT,
    `email`		VARCHAR(30) UNIQUE NOT NULL,
    `username`	VARCHAR(25) UNIQUE NOT NULL,
    `password`	VARCHAR(100) NOT NULL,
    `enabled`	BOOL -- ,
-- 	`image`		BLOB
);

CREATE TABLE `UserRole`(
	`userId` INT NOT NULL,
    `roleId` INT NOT NULL,
    
    PRIMARY KEY (`userId`, `roleId`),
    FOREIGN KEY `fk_UserRole_User` (`userId`) REFERENCES `User` (`userId`),
    FOREIGN KEY `fk_UserRole_Role` (`roleId`) REFERENCES `Role` (`roleId`)
);

CREATE TABLE `Post`(
	`postId`	INT PRIMARY KEY AUTO_INCREMENT,
    `title`		VARCHAR(20) NOT NULL,
    `static`	BOOL,
    `enabled`	BOOL DEFAULT FALSE,
    `body`		TEXT NOT NULL,
	`start`		DATE NOT NULL,
    `end`		DATE,
    `userId`	INT NOT NULL,
    
    FOREIGN KEY `fk_Post_User` (`userId`) REFERENCES `User` (`userId`)
);

CREATE TABLE `Comment`(
	`commentId`	INT PRIMARY KEY AUTO_INCREMENT,
    `datetime`	DATETIME DEFAULT NOW(),
    `text`		VARCHAR(255),
    `userId`	INT NOT NULL,
    `postId`	INT NOT NULL,
    
    FOREIGN KEY `fk_Comment_User`(`userId`) REFERENCES `User`(`userId`),
    FOREIGN KEY `fk_Comment_Post` (`postId`) REFERENCES `Post`(`postId`)
);

CREATE TABLE `Hashtag`(
	`hashtagId`	INT PRIMARY KEY AUTO_INCREMENT,
	`name`		varchar(35) UNIQUE NOT NULL
);

CREATE TABLE `PostHashtag`(
	`postId`	INT NOT NULL,
    `hashtagId`	INT NOT NULL,
    
    PRIMARY KEY (`postId`, `hashtagId`),
    FOREIGN KEY `fk_PostHashtag_Post` (`postId`) REFERENCES `Post` (`postId`),
    FOREIGN KEY `fk_PostHashtag_Hashtag` (`hashtagId`) REFERENCES `Hashtag` (`hashtagId`)
);

insert into role (name) values ("ROLE_ADMIN");
insert into role (name) values ("ROLE_EMPLOYEE");
insert into role (name) values ("ROLE_USER");
insert into user (username, email, `password`, enabled)
values ("admin", "rtdonin@gmail.com", "$2a$10$abSRI52Y/FpmIk1j55g8GOZRmWgrUwNWW/0qBaNAhhTzXK5sXPUtu", 1),
	("employee", "silly@email.com", "$2a$10$abSRI52Y/FpmIk1j55g8GOZRmWgrUwNWW/0qBaNAhhTzXK5sXPUtu", 1);
insert into userrole values (1, 1);
insert into userrole values (1, 2);
insert into userrole values (1, 3);
insert into userrole values (2, 2);
insert into userrole values (2, 3);

insert into post (title, static, enabled, body, start, end, userId) values
("hello", 0, 1, "jhreh e rherbge hjr gbher gkjhrehe rherbgehj rgbh 
ergkjhreher herb ge hjr gbh er g kj hreher herbge hjrgbhe rgkjh reherher 
bgeh jrgb herg kjhrehe rherbgeh jrgb her gkjhrehe rherb gehjrgb hergkj 
hreher herbg ehjrgbh ergkj hreher herbgeh jrgbhergkjhhreh e rherbge hjr gbher gkjhrehe rherbgehj rgbh 
ergkjhreher herb ge hjr gbh er g kj hreher herbge hjrgbhe rgkjh reherher 
bgeh jrgb herg kjhrehe rherbgeh jrgb her gkjhrehe rherb gehjrgb hergkj 
hreher herbg ehjrgbh ergkj hreher herbgeh jrgbhergkjhhreh e rherbge hjr gbher gkjhrehe rherbgehj rgbh 
ergkjhreher herb ge hjr gbh er g kj hreher herbge hjrgbhe rgkjh reherher 
bgeh jrgb herg kjhrehe rherbgeh jrgb her gkjhrehe rherb gehjrgb hergkj 
hreher herbg ehjrgbh ergkj hreher herbgeh jrgbhergkjh", '2020-10-05', '2100-10-05', 1),
("static1", 1, 1, "furhfurdfgyufebuebgfhugfhldfjhjdhdgsuiyberygkjxfvhdafgfyEWGYUWGJSDHG HDSGFYGDYFBHGGHCXGFYPd", '2020-10-05', '2100-10-05', 1);

insert into comment (text, userId, postId) values ("fjgherubuiirragrvrnhjadgvgnh;a", 1, 1);

SELECT
	u.username,
    r.`name`
FROM `User` u
JOIN `UserRole` ur
	ON u.userId = ur.userId
JOIN `Role` r
	ON r.roleId = ur.roleId;