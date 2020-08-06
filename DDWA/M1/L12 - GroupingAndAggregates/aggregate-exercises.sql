USE PersonalTrainer;

-- Use an aggregate to count the number of Clients.
-- 500 rows
--------------------
SELECT
	COUNT(*)
FROM Client;

-- Use an aggregate to count Client.BirthDate.
-- The number is different than total Clients. Why?
		-- People can have the same BirthDate
-- 463 rows
--------------------
SELECT
	COUNT(c.BirthDate)
FROM `Client` c;

-- Group Clients by City and count them.
-- Order by the number of Clients desc.
-- 20 rows
--------------------
SELECT
	c.City,
	COUNT(*) Total
FROM `Client` c
GROUP BY c.City
ORDER BY Total DESC;

-- Calculate a total per invoice using only the InvoiceLineItem table.
-- Group by InvoiceId.
-- You'll need an expression for the line item total: Price * Quantity.
-- Aggregate per group using SUM().
-- 1000 rows
--------------------
SELECT
	i.InvoiceId,
    i.Price * i.Quantity AS Total
FROM InvoiceLineItem i
GROUP BY i.InvoiceId;

-- Calculate a total per invoice using only the InvoiceLineItem table.
-- (See above.)
-- Only include totals greater than $500.00.
-- Order from lowest total to highest.
-- 234 rows
--------------------
SELECT
	InvoiceId,
    SUM(Price * Quantity) AS Total
FROM InvoiceLineItem i
GROUP BY InvoiceId
HAVING SUM(Price * Quantity) > 500
ORDER BY Total ASC;

-- Calculate the average line item total
-- grouped by InvoiceLineItem.Description.
-- 3 rows
--------------------
SELECT
	`Description`,
    AVG(Price * Quantity) AS Total
FROM InvoiceLineItem 
GROUP BY `Description`
ORDER BY Total ASC;

-- Select ClientId, FirstName, and LastName from Client
-- for clients who have *paid* over $1000 total.
-- Paid is Invoice.InvoiceStatus = 2.
-- Order by LastName, then FirstName.
-- 146 rows
--------------------
SELECT
    c.ClientId,
    c.FirstName,
    c.LastName,
    SUM(li.Quantity * li.Price) Total
FROM `Client` c
INNER JOIN Invoice i
	ON c.ClientId = i.ClientId
INNER JOIN InvoiceLineItem li
	ON i.InvoiceId = li.InvoiceId
WHERE i.InvoiceStatus = 2
GROUP BY
	c.ClientId,
    c.FirstName,
    c.LastName
HAVING SUM(li.Quantity * li.Price) > 1000
ORDER BY
	c.LastName,
    c.FirstName;

-- Count exercises by category.
-- Group by ExerciseCategory.Name.
-- Order by exercise count descending.
-- 13 rows
--------------------
SELECT
	e.`Name` ExerciseName,
    ec.`Name` CategoryName,
    COUNT(ec.`Name`)
FROM Exercise e
INNER JOIN ExerciseCategory ec
	ON e.ExerciseCategoryId = ec.ExerciseCategoryId
GROUP BY ec.`Name`
Order BY COUNT(ec.`Name`) DESC;

-- Select Exercise.Name along with the minimum, maximum,
-- and average ExerciseInstance.Sets.
-- Order by Exercise.Name.
-- 64 rows
--------------------
SELECT
	e.`Name` ExerciseName,
    MIN(ei.Sets) Minimum,
    MAX(ei.Sets) Maximum,
    AVG(ei.Sets) Average
FROM Exercise e
Inner JOIN ExerciseInstance ei
	ON e.ExerciseId = ei.ExerciseId
GROUP BY
	e.`Name`,
    ei.ExerciseId
Order BY
	e.`Name`;

-- Find the minimum and maximum Client.BirthDate
-- per Workout.
-- 26 rows
-- Sample: 
-- WorkoutName, EarliestBirthDate, LatestBirthDate
-- '3, 2, 1... Yoga!', '1928-04-28', '1993-02-07'
--------------------
SELECT
	w.`Name` WorkoutName,
    MIN(c.BirthDate) EarliestBirthDate,
    MAX(c.BirthDate) LatestBirthDate
FROM `Client` c
INNER JOIN ClientWorkout cw
	ON c.ClientId = cw.ClientId
INNER JOIN workout w
	ON cw.WorkoutId = w.WorkoutId
GROUP BY
	w.`Name`;

-- Count client goals.
-- Be careful not to exclude rows for clients without goals.
-- 500 rows total
-- 50 rows with no goals
--------------------
SELECT
	c.ClientId,
    COUNT(cg.GoalId) GoalCount
FROM `Client` c
LEFT JOIN ClientGoal cg
	ON c.ClientId = cg.ClientId
GROUP BY
	c.ClientId
ORDER BY
	COUNT(cg.GoalId) ASC;

-- Select Exercise.Name, Unit.Name, 
-- and minimum and maximum ExerciseInstanceUnitValue.Value
-- for all exercises with a configured ExerciseInstanceUnitValue.
-- Order by Exercise.Name, then Unit.Name.
-- 82 rows
--------------------
SELECT
	e.`Name` ExerciseName,
    u.`Name` UnitName,
    MIN(uv.`Value`) MinimumValue,
	MAX(uv.`Value`) MaximumValue
FROM Exercise e
INNER JOIN ExerciseInstance ei
	ON e.ExerciseId = ei.ExerciseId
INNER JOIN ExerciseInstanceUnitValue uv
	ON ei.ExerciseInstanceId = uv.ExerciseInstanceId
LEFT OUTER JOIN Unit u
	ON uv.UnitId = u.UnitId
GROUP BY
	e.ExerciseId,
    u.UnitId
ORDER BY
	e.`Name`,
    u.`Name`;
    
-- Modify the query above to include ExerciseCategory.Name.
-- Order by ExerciseCategory.Name, then Exercise.Name, then Unit.Name.
-- 82 rows
--------------------
SELECT
	e.`Name` ExerciseName,
    u.`Name` UnitName,
    MIN(uv.`Value`) MinimumValue,
	MAX(uv.`Value`) MaximumValue,
    ec.`Name` ExerciseCategoryName
FROM Exercise e
INNER JOIN ExerciseInstance ei
	ON e.ExerciseId = ei.ExerciseId
INNER JOIN ExerciseInstanceUnitValue uv
	ON ei.ExerciseInstanceId = uv.ExerciseInstanceId
INNER JOIN ExerciseCategory ec
	ON e.ExerciseCategoryId = ec.ExerciseCategoryId
LEFT OUTER JOIN Unit u
	ON uv.UnitId = u.UnitId
GROUP BY
	e.ExerciseId,
    u.UnitId
ORDER BY
	ec.`Name`,
	e.`Name`,
    u.`Name`;

-- Select the minimum and maximum age in years for
-- each Level.
-- To calculate age in years, use the MySQL function DATEDIFF.
-- 4 rows
--------------------
SELECT
	l.`Name` `Level`,
    MIN(DATEDIFF(CURDATE(), c.BirthDate) / 365) MinAge,
    MAX(DATEDIFF(CURDATE(), c.BirthDate) / 365) MaxAge
FROM `Client` c
INNER JOIN ClientWorkout cw
	ON c.ClientId = cw.ClientId
INNER JOIN Workout w
	ON cw.WorkoutId = w.WorkoutId
INNER JOIN `Level` l
	ON w.LevelId = l.LevelId
GROUP BY
	l.LevelId;

-- Stretch Goal!
-- Count logins by email extension (.com, .net, .org, etc...).
-- Research SQL functions to isolate a very specific part of a string value.
-- 27 rows (27 unique email extensions)
--------------------
SELECT
	SUBSTRING_INDEX(l.EmailAddress, ".", -1) Email,
    COUNT(c.ClientId) Clients
FROM `Client` c
INNER JOIN Login l
	ON c.ClientId = l.ClientId
GROUP BY
	SUBSTRING_INDEX(l.EmailAddress, ".", -1);

-- Stretch Goal!
-- Match client goals to workout goals.
-- Select Client FirstName and LastName and Workout.Name for
-- all workouts that match at least 2 of a client's goals.
-- Order by the client's last name, then first name.
-- 139 rows
-------------------- 
SELECT
	c.FirstName FirstName,
    c.LastName LastName,
    w.`Name` Workout
FROM ClientGoal cg
INNER JOIN `Client` c
	ON cg.ClientId = c.ClientId
INNER JOIN Goal g
	ON cg.GoalId = g.GoalId
INNER JOIN WorkoutGoal wg
	ON g.GoalId = wg.GoalId
INNER JOIN Workout w
	ON wg.WorkoutId = w.WorkoutId
GROUP BY
	w.WorkoutId,
    w.`Name`,
    c.ClientId,
    c.FirstName,
    c.LastName
HAVING
	COUNT(cg.GoalId) > 1
ORDER BY
	c.LastName,
    c.FirstName,
    wg.GoalId;
