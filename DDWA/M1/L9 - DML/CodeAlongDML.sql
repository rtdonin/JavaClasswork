INSERT INTO Worker (WorkerId, FirstName, LastName)
	VALUES (1, 'Rosemonde', 'Featherbie');
INSERT INTO Worker (FirstName, LastName)
    VALUES ('Kingsly', 'Besantie');
INSERT INTO Worker (FirstName, LastName) VALUES
    ('Goldi','Pilipets'),
    ('Dorey','Rulf'),
    ('Panchito','Ashtonhurst');
INSERT INTO Worker (WorkerId, FirstName, LastName)
    VALUES (50, 'Valentino', 'Newvill');

INSERT INTO Project (ProjectId, `Name`, DueDate)
	VALUES ('db-milestone', 'Database Material', '2018-12-31');

INSERT INTO ProjectWorker (ProjectId, WorkerId)
	VALUES ('db-milestone', 75);
INSERT INTO Project (ProjectId, `Name`, DueDate)
	VALUES ('kitchen', 'Kitchen Remodel', '2025-07-15'); 
INSERT INTO ProjectWorker (ProjectId, WorkerId) VALUES 
    ('db-milestone', 1), -- Rosemonde, Database
    ('kitchen', 2),      -- Kingsly, Kitchen
    ('db-milestone', 3), -- Goldi, Database
    ('db-milestone', 4); -- Dorey, Database
    
-- Provide a Project Summary and change the DueDate.
UPDATE Project SET
    Summary = 'All lessons and exercises for the relational database milestone.',
    DueDate = '2018-10-15'
WHERE ProjectId = 'db-milestone';

-- Change Kingsly's LastName to 'Oaks'.
UPDATE Worker SET
    LastName = 'Oaks'
WHERE WorkerId = 2;

-- Disable safe updates.
SET SQL_SAFE_UPDATES = 0;

-- Deactivate active Projects from 2017.
UPDATE Project SET
    IsActive = 0
WHERE DueDate BETWEEN '2017-01-01' AND '2017-12-31'
AND IsActive = 1;

-- Enable safe updates.
SET SQL_SAFE_UPDATES = 1;

-- Do you need safe updates disabled?
SET SQL_SAFE_UPDATES = 0;

-- Update all of Kingsly's Task estimates to include 25% more time.
UPDATE Task SET
    EstimatedHours = EstimatedHours * 1.25
WHERE WorkerId = 2;

-- Delete our out-of-order WorkerId.
DELETE FROM Worker
WHERE WorkerId = 50;

-- Safe updates also prevent DELETE.
SET SQL_SAFE_UPDATES = 0;

DELETE FROM Worker
WHERE FirstName = 'Kingsly';

SET SQL_SAFE_UPDATES = 1;

SET SQL_SAFE_UPDATES = 0;

-- Delete Tasks first since Task references ProjectWorker.
DELETE FROM Task
WHERE WorkerId = 2;

-- Delete ProjectWorker next. 
-- That removes Kingsly from all Projects.
DELETE FROM ProjectWorker
WHERE WorkerId = 2;

-- Finally, remove Kingsly.
DELETE FROM Worker
WHERE WorkerId = 2;

SET SQL_SAFE_UPDATES = 1;
