USE TrackIt;

SELECT *
FROM TaskStatus
WHERE IsResolved = 1;

SELECT *
FROM Task
WHERE TaskStatusId BETWEEN 5 AND 8;

SELECT
	Task.TaskId,
    Task.Title,
    TaskStatus.Name
FROM TaskStatus
INNER JOIN Task ON TaskStatus.TaskStatusId = Task.TaskStatusId
WHERE TaskStatus.IsResolved = 1;

-- Compare this with no table names:
SELECT 
    TaskId,
    Title,
    `Name`
FROM TaskStatus
INNER JOIN Task ON TaskStatus.TaskStatusId = Task.TaskStatusId
WHERE TaskStatus.IsResolved = 1;
-- but if TaskStatusId was used there an error because it's ambiguous.

-- INNER is a defualt
SELECT 
    TaskId,
    Title,
    `Name`
FROM TaskStatus
JOIN Task ON TaskStatus.TaskStatusId = Task.TaskStatusId -- INNER omitted
WHERE TaskStatus.IsResolved = 1;

SELECT
	Project.Name,
	Worker.FirstName,
    Worker.LastName
FROM Project
INNER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
INNER JOIN Worker ON ProjectWorker.WorkerId = Worker.WorkerId
WHERE Project.ProjectId = 'game-goodboy';

SELECT
	Project.Name,
    Worker.FirstName,
    Worker.LastName,
    Task.Title
FROM Project
INNER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
INNER JOIN Worker ON ProjectWorker.WorkerId = Worker.WorkerId
INNER JOIN Task ON ProjectWorker.ProjectId = Task.ProjectId
	AND ProjectWorker.WorkerId = Task.WorkerId
WHERE Project.ProjectId = 'game-goodboy';

SELECT *
FROM Task;

SELECT *
FROM Task
INNER JOIN TaskStatus ON Task.TaskStatusId = TaskStatus.TaskStatusID;

SELECT *
FROM Task
WHERE TaskStatusId IS NULL;

SELECT *
FROM Task
LEFT OUTER JOIN TaskStatus
	ON Task.TaskStatusId = TaskStatus.TaskStatusId;

SELECT
	Task.TaskId,
    Task.Title,
    IFNULL(Task.TaskStatusId, 0) AS TaskStatusId,
    IFNULL(TaskStatus.Name, '[NONE]') AS StatusName
FROM Task
LEFT OUTER JOIN TaskStatus
	ON Task.TaskStatusId = TaskStatus.TaskStatusId;

-- key word AS is optional

SELECT
    Project.Name ProjectName, -- An alias makes this more clear.
    Worker.FirstName,
    Worker.LastName
FROM Project
LEFT OUTER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
LEFT OUTER JOIN Worker ON ProjectWorker.WorkerId = Worker.WorkerId;

-- The missing relationship

SELECT
    Project.Name ProjectName,
    Worker.FirstName,
    Worker.LastName
FROM Project
LEFT OUTER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
LEFT OUTER JOIN Worker ON ProjectWorker.WorkerId = Worker.WorkerId
WHERE ProjectWorker.WorkerId IS NULL; -- Throws out projects with workers.

-- Projects without workers, we only need the bridge table to confirm.
SELECT
    Project.Name ProjectName
FROM Project
LEFT OUTER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
WHERE ProjectWorker.WorkerId IS NULL;

SELECT
    Project.Name ProjectName,
    Worker.FirstName,
    Worker.LastName
FROM Project
RIGHT OUTER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
RIGHT OUTER JOIN Worker ON ProjectWorker.WorkerId = Worker.WorkerId
WHERE ProjectWorker.ProjectId IS NULL;

SELECT
    Worker.FirstName,
    Worker.LastName
FROM Worker
LEFT OUTER JOIN ProjectWorker ON Worker.WorkerId = ProjectWorker.WorkerId
WHERE ProjectWorker.WorkerId IS NULL;

SELECT
	parent.TaskId ParentTaskId,
    child.TaskId ChildTaskId,
    CONCAT(Parent.Title, ': ', child.Title) Title
FROM Task parent
INNER JOIN Task child ON parent.TaskId = child.ParentTaskId;

SELECT
    p.Name ProjectName,
    w.FirstName,
    w.LastName,
    t.Title
FROM Project p
INNER JOIN ProjectWorker pw ON p.ProjectId = pw.ProjectId
INNER JOIN Worker w ON pw.WorkerId = w.WorkerId
INNER JOIN Task t ON pw.ProjectId = t.ProjectId
    AND pw.WorkerId = t.WorkerId
WHERE p.ProjectId = 'game-goodboy';

SELECT
   CONCAT(w.FirstName, ' ', w.LastName) WorkerName,
   p.Name ProjectName
FROM Worker w
CROSS JOIN Project p
WHERE w.WorkerId = 1
AND p.ProjectId NOT LIKE 'game-%';