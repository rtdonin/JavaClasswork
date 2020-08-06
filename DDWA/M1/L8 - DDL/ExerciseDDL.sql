DROP DATABASE IF EXISTS MovieCatalogue;

CREATE DATABASE MovieCatalogue;

USE MovieCatalogue;

CREATE TABLE Genre (
	GenreId INT PRIMARY KEY AUTO_INCREMENT,
    GenreName CHAR(30) NOT NULL
);

CREATE TABLE Director (
	DirectorId INT PRIMARY KEY AUTO_INCREMENT,
    FirstName CHAR(30) NOT NULL,
    LastName CHAR(30) NOT NULL,
    BirthDate DATE NULL
);

CREATE TABLE Rating (
	RatingID INT PRIMARY KEY AUTO_INCREMENT,
    RatingName CHAR(5) NOT NULL
);

CREATE TABLE Actor (
	ActorId INT PRIMARY KEY AUTO_INCREMENT,
    FirstName CHAR(30) NOT NULL,
    LastName CHAR(30) NOT NULL,
    BirthDate DATE NULL
);

CREATE TABLE Movie (
	MovieId INT PRIMARY KEY AUTO_INCREMENT,
    GenreId INT NOT NULL,
    DirectorId INT,
    RatingId INT NULL,
    Title CHAR(128) NOT NULL,
	ReleaseDate DATE,
    
    FOREIGN KEY fk_Movie_Genre (GenreId)
		REFERENCES Genre(GenreId),
	FOREIGN KEY fk_Movie_Director (DirectorId)
		REFERENCES Director(DirectorId),
	FOREIGN KEY fk_Movie_Rating (RatingId)
		REFERENCES Rating(RatingId)
);

CREATE TABLE CastMember (
	CastMemberId INT PRIMARY KEY AUTO_INCREMENT,
    ActorId INT NOT NULL,
    MovieId INT NOT NULL,
    `Role` CHAR(50) NOT NULL,
	
    FOREIGN KEY fk_CastMembers_Actor (ActorId)
		REFERENCES Actor(ActorId),
	FOREIGN KEY fk_CastMembers_Movie (MovieId)
		REFERENCES Movie(MovieId)
);
