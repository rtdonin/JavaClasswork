USE moviecatalogue;

INSERT INTO Actor (FirstName, LastName, BirthDate) VALUES
	('Bill', 'Murray', '1950/09/21'),
    ('Dan', 'Aykroyd', '1952/07/01'),
    ('John', 'Candy', '1950/10/21'),
	('Steve', 'Martin', NULL),
	('Sylvester', 'Stallone', NULL);

INSERT INTO Director (FirstName, LastName, BirthDate) VALUES
	('Ivan', 'Reitman', '1947/10/27'),
    ('Ted', 'Kotcheff', NULL);

INSERT INTO Rating (RatingName) VALUES
	('G'),
    ('PG'),
    ('PG-13'),
    ('R');

INSERT INTO Genre (GenreName) VALUES
	('Action'),
    ('Comedy'),
    ('Drama'),
    ('Horror');

INSERT INTO Movie (GenreId, DirectorId, RatingId, Title, ReleaseDate) VALUES
	(1, 2, 4, 'Ramboo: First Blood', '1982/10/22'),
    (2, NULL, 4, 'Planes, Trains & Automobiles', '1987/11/25'),
    (2, 1, 2, 'Ghostbusters', NULL),
    (2, NULL, 2, 'The Great Outdoors', '1988/06/17');
    
INSERT INTO CastMember (ActorId, MovieId, `Role`) VALUES
	(5, 1, 'John Rambo'),
    (4, 2, 'Neil Page'),
    (3,	2,	'Del Griffith'),
	(1,	3,	'Dr. Peter Venkman'),
    (2,	3,	'Dr. Raymond Stanz'),
    (2,	4,	'Roman Craig'),
    (3,	4,	'Chet Ripley');
    
UPDATE Movie SET
	Title = 'Ghostbusters (1984)',
    ReleaseDate = '1984/06/08'
WHERE MovieId = 3;

UPDATE Genre SET
	GenreName = 'Action/Adventure'
WHERE GenreId = 1;

DELETE FROM CastMember
WHERE MovieId = 1;

DELETE FROM Movie
WHERE MovieId = 1;

SELECT *
FROM movie;

ALTER TABLE Actor
	ADD COLUMN (
		DateOfDeath DATE NULL
	);

UPDATE Actor SET
	DateOfDeath = '1994-03-04'
WHERE ActorId = 3;