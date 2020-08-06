USE TrackIt;

-- Count TaskIds, 543 values
SELECT COUNT(TaskId)
FROM Task;

-- Count everything, 543 values
SELECT COUNT(*)
FROM Task;

-- 532
SELECT COUNT(TaskStatusId)
FROM Task;

-- 276
SELECT
    COUNT(t.TaskId)
FROM Task t
INNER JOIN TaskStatus s ON t.TaskStatusId = s.TaskStatusId
WHERE s.IsResolved = 1;

SELECT
	IFNULL(s.`Name`, '[NONE]') StatusName,
    COUNT(t.TaskId) TaskCount
FROM Task t
LEFT OUTER JOIN TaskStatus s
	ON t.TaskStatusId = s.TaskStatusId
GROUP BY s.`Name`
ORDER BY s.`Name`;

-- Should not work but does beasue MySQL is forgiving
SELECT
	IFNULL(s.`Name`, '[NONE]') StatusName,
    s.IsResolved,
    COUNT(t.TaskId) TaskCount
FROM Task t
LEFT OUTER JOIN TaskStatus s
	ON t.TaskStatusId = s.TaskStatusId
GROUP BY s.`Name`
ORDER BY s.`Name`;

SELECT
	IFNULL(s.`Name`, '[NONE]') StatusName,
    IFNULL(s.IsResolved, 0) IsResolved,
    COUNT(t.TaskId) TaskCount
FROM Task t
LEFT OUTER JOIN TaskStatus s
	ON t.TaskStatusId = s.TaskStatusId
GROUP BY s.`Name`, s.IsResolved -- IsResolved is now part of the GROUP
ORDER BY s.`Name`;

-- 88 rows
SELECT
	CONCAT(w.FirstName, ' ', w.LastName) WorkerName,
    SUM(t.EstimatedHours) TotalHours
FROM Worker w
INNER JOIN ProjectWorker pw
	ON w.WorkerId = pw.WorkerId
INNER JOIN Task t
	ON pw.WorkerId = t.WorkerId
		AND pw.ProjectId = t.ProjectId
GROUP BY
	w.WorkerId,
	w.FirstName,
    w.LastName;

-- 9 rows
SELECT
	CONCAT(w.FirstName, ' ', w.LastName) WorkerName,
    SUM(t.EstimatedHours) TotalHours
FROM Worker w
INNER JOIN ProjectWorker pw
	ON w.WorkerId = pw.WorkerId
INNER JOIN Task t
	ON pw.WorkerId = t.WorkerId
		AND pw.ProjectId = t.ProjectId
GROUP BY
	w.WorkerId,
	w.FirstName,
    w.LastName
HAVING SUM(t.EstimatedHours) >= 100
ORDER BY SUM(t.EstimatedHours) DESC;

SELECT
	p.`Name` ProjectName,
    MIN(t.DueDate) MinTaskDueDate
FROM Project p
INNER JOIN Task t
	ON p.ProjectId = t.ProjectId
WHERE p.ProjectId LIKE 'game-%'
	AND t.ParentTaskId IS NOT NULL
GROUP BY
	p.ProjectId,
    p.`Name`
ORDER BY p.`Name`;

SELECT
    p.Name ProjectName,
    MIN(t.DueDate) MinTaskDueDate,
    MAX(t.DueDate) MaxTaskDueDate,
    SUM(t.EstimatedHours) TotalHours,
    AVG(t.EstimatedHours) AverageTaskHours,
    COUNT(t.TaskId) TaskCount
FROM Project p
INNER JOIN Task t ON p.ProjectId = t.ProjectId
WHERE t.ParentTaskId IS NOT NULL
GROUP BY p.ProjectId, p.Name
HAVING COUNT(t.TaskId) >= 10
ORDER BY COUNT(t.TaskId) DESC, p.Name;

-- 543 rows
SELECT
    p.ProjectId,
    p.Name ProjectName
FROM Project p
INNER JOIN Task t ON p.ProjectId = t.ProjectId
ORDER BY p.Name;

-- 26 rows
SELECT DISTINCT
    p.ProjectId,
    p.Name ProjectName
FROM Project p
INNER JOIN Task t ON p.ProjectId = t.ProjectId
ORDER BY p.Name;


