-- Created by: Margaret Donin
-- Date created: 08/06/20
-- Date revised:

-- M1 Assessment Queries

-- 1. Write a query that returns a list of reservations that end in July 2023, including the name of the guest, the room number(s), and the reservation dates.
 
 SELECT 
	CONCAT(g.`FirstName`, ' ', g.`LastName`) GuestName,
    r.`roomId` RoomNumber,
    rv.`Start` ReservationStart,
    rv.`End` ReservationEnd
FROM `Guest` g
INNER JOIN `Reservation` rv
	ON g.`GuestId` = rv.`GuestId`
INNER JOIN `Room` r
	ON rv.`RoomId` = r.`RoomId`
WHERE rv.`End` BETWEEN '2023-07-01' AND '2023-07-31';

-- Margaret Donin	205	2023-06-28	2023-07-02
-- Walter Holaway	204	2023-07-13	2023-07-14
-- Wilfred Vise	401	2023-07-18	2023-07-21
-- Bettyann Seery	303	2023-07-28	2023-07-29

--------------------------------------------------------------------------- 
-- 2. Write a query that returns a list of all reservations for rooms with a jacuzzi, displaying the guest's name, the room number, and the dates of the reservation.

SELECT
	CONCAT(g.`FirstName`, ' ', g.`LastName`) GuestName,
    r.`RoomId` RoomNumber,
    rv.`Start` ReservationStart,
    rv.`End` ReservationEnd
FROM `Guest` g
INNER JOIN `Reservation` rv
	ON g.`GuestId` = rv.`GuestId`
INNER JOIN `Room` r
	ON rv.`RoomId` = r.`RoomId`
INNER JOIN `RoomAmenity` ra
	ON r.`RoomId` = ra.`RoomId`
INNER JOIN `Amenity` a
	ON ra.`AmenityId` = a.`AmenityId`
WHERE a.`Name` = 'Jacuzzi'
GROUP BY rv.`ReservationId`;

-- Karie Yang	201	2023-03-06	2023-03-07
-- Bettyann Seery	203	2023-02-05	2023-02-10
-- Karie Yang	203	2023-09-13	2023-09-15
-- Margaret Donin	205	2023-06-28	2023-07-02
-- Wilfred Vise	207	2023-04-23	2023-04-24
-- Walter Holaway	301	2023-04-09	2023-04-13
-- Mack Simmer	301	2023-11-22	2023-11-25
-- Bettyann Seery	303	2023-07-28	2023-07-29
-- Duane Cullison	305	2023-02-22	2023-02-24
-- Bettyann Seery	305	2023-08-30	2023-09-01
-- Margaret Donin	307	2023-03-17	2023-03-20

--------------------------------------------------------------------------- 
-- 3. Write a query that returns all the rooms reserved for a specific guest, including the guest's name, the room(s) reserved, the starting date of the reservation,
-- and how many people were included in the reservation. (Choose a guest's name from the existing data.)

SELECT
	CONCAT(g.`FirstName`, ' ', g.`LastName`) GuestName,
    r.`RoomId` RoomNumber,
    r.`Start` ReservationStart,
    SUM(r.`Adult` + r.`Children`) TotalPeople
FROM `Guest` g
INNER JOIN `Reservation` r
	ON g.`GuestId` = r.`GuestId`
WHERE CONCAT(g.`FirstName`, ' ', g.`LastName`) = 'Karie Yang'
GROUP BY r.`ReservationId`;

-- Karie Yang	201	2023-03-06	2	2	4
-- Karie Yang	203	2023-09-13	2	2	4

--------------------------------------------------------------------------- 
-- 4. Write a query that returns a list of rooms, reservation ID, and per-room cost for each reservation. The results should include all rooms, whether or not there is a
-- reservation associated with the room.

SELECT
	r.`RoomId` RoomNumber,
    rv.`ReservationId` ReservationId,
    rv.`Price` ReservationCost
FROM `Room` r
LEFT OUTER JOIN `Reservation` rv
	ON r.`RoomId` = rv.`RoomId`
ORDER BY r.`RoomId`;

-- 201	4	199.99
-- 202	7	349.98
-- 203	2	999.95
-- 203	21	399.98
-- 204	16	184.99
-- 205	15	699.96
-- 206	12	599.96
-- 206	23	449.97
-- 207	10	174.99
-- 208	13	599.96
-- 208	20	149.99
-- 301	9	799.96
-- 301	24	599.97
-- 302	6	924.95
-- 302	25	699.96
-- 303	18	199.99
-- 304	14	184.99
-- 305	3	349.98
-- 305	19	349.98
-- 306		
-- 307	5	524.97
-- 308	1	299.98
-- 401	11	1199.97
-- 401	17	1259.97
-- 401	22	1199.97
-- 402		

--------------------------------------------------------------------------- 
-- 5. Write a query that returns all the rooms accommodating at least three guests and that are reserved on any date in April 2023.

SELECT
	r.`RoomId` RoomNumber,
    rt.`MaximumOccupancy` MaximumOccupancy,
    rv.`Start` StartDate,
    rv.`End` EndDate
FROM `Reservation` rv
INNER JOIN `Room` r
	ON rv.`RoomId` = r.`RoomId`
INNER JOIN `RoomType` rt
	ON r.`RoomTypeId` = rt.`RoomTypeId`
WHERE rt.MaximumOccupancy >= 3
	AND rv.`Start` <= '2023-04-30'
    AND rv.`End` >= '2023-04-01'
GROUP BY r.`RoomId`;

-- 301	4	2023-04-09	2023-04-13

--------------------------------------------------------------------------- 
-- 6. Write a query that returns a list of all guest names and the number of reservations per guest, sorted starting with the guest with the most reservations and then by the guest's last name.

SELECT
	CONCAT(g.`FirstName`, ' ', g.`LastName`) GuestName,
    COUNT(rv.`ReservationId`) NumberOfReservation
FROM `Guest` g
INNER JOIN `Reservation` rv
	ON g.GuestId = rv.GuestId
GROUP BY
	g.`GuestId`
ORDER BY
	COUNT(rv.`ReservationId`) DESC,
    g.`LastName`;

-- Mack Simmer	4
-- Bettyann Seery	3
-- Duane Cullison	2
-- Margaret Donin	2
-- Walter Holaway	2
-- Aurore Lipton	2
-- Maritza Tilton	2
-- Joleen Tison	2
-- Wilfred Vise	2
-- Karie Yang	2
-- Zachery Luechtefeld	1

--------------------------------------------------------------------------- 
-- 7. Write a query that displays the name, address, and phone number of a guest based on their phone number. (Choose a phone number from the existing data.)

SELECT
	CONCAT(g.`FirstName`, ' ', g.`LastName`) GuestName,
    g.`Address` Address,
    g.`Phone` PhoneNumber
FROM `Guest` g
WHERE g.`Phone` = '(308) 494-0198';

-- Duane Cullison	9662 Foxrun Lane	(308) 494-0198
