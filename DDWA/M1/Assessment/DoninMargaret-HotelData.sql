-- Created by: Margaret Donin
-- Date created: 08/05/20
-- Date revised:

USE HotelSoftwareGuild;

INSERT INTO `Amenity` (`Name`)
VALUES ('Microwave'),
	('Jacuzzi'),
	('Refrigerator'),
	('Oven');

INSERT INTO `RoomType` (`Name`, `StandardOccupancy`, `MaximumOccupancy`, `BasePrice`, `ExtraPerson`)
VALUES ('Double', 2, 4, 174.99, 10),
	('Single', 2, 2, 149.99, NULL),
	('Suite', 3, 8, 399.99, 20);

INSERT INTO `Room` (`RoomId`, `RoomTypeId`, `AdaAccessible`)
VALUES (201, 1, FALSE),
	(202, 1, TRUE),
    (203, 1, FALSE),
    (204, 1, TRUE),
    (205, 2, FALSE),
    (206, 2, TRUE),
    (207, 2, FALSE),
    (208, 1, TRUE),
    (301, 1, FALSE),
	(302, 1, TRUE),
    (303, 1, FALSE),
    (304, 1, TRUE),
    (305, 2, FALSE),
    (306, 2, TRUE),
    (307, 2, FALSE),
    (308, 2, TRUE),
    (401, 3, TRUE),
    (402, 3, TRUE);

INSERT INTO `RoomAmenity` (`RoomId`, `AmenityId`)
VALUES (201, 1),
	(201, 2),
    (202, 3),
    (203, 1),
    (203, 2),
    (204, 3),
    (205, 1),
    (205, 2),
    (205, 3),
    (206, 1),
    (206, 3),
    (207, 1),
    (207, 2),
    (207, 3),
    (208, 1),
    (208, 3),
    (301, 1),
    (301, 2),
    (302, 3),
    (303, 1),
    (303, 2),
    (304, 3),
    (305, 1),
    (305, 2),
    (305, 3),
    (306, 1),
    (306, 3),
    (307, 1),
    (307, 2),
    (307, 3),
    (308, 1),
    (308, 3),
    (401, 1),
    (401, 3),
    (401, 4),
    (402, 1),
    (402, 3),
    (402, 4);

INSERT INTO `Guest` (`FirstName`, `LastName`, `Address`, `City`, `State`, `Zip`, `Phone`)
VALUES ('Mack', 'Simmer', '379 Old Shore Street', 'Council Bluffs', 'IA', '51501', '(291) 553-0508'),
	('Bettyann', 'Seery', '750 Wintergreen Dr.', 'Wasilla', 'AK', '99654', '(478) 277-9632'),
	('Duane', 'Cullison', '9662 Foxrun Lane', 'Harlingen', 'TX', '78552', '(308) 494-0198'),
	('Karie', 'Yang', '9378 W. Augusta Ave.', 'West Deptford', 'NJ', '08096', '(214) 730-0298'),
	('Aurore', 'Lipton', '762 Wild Rose Street', 'Saginaw', 'MI', '48601', '(377) 507-0974'),
	('Zachery', 'Luechtefeld', '7 Poplar Dr.', 'Arvada', 'CO', '80003', '(814) 485-2615'),
	('Jeremiah', 'Pendergrass', '70 Oakwood St.', 'Zion', 'IL', '60099', '(279) 491-0960'),
	('Walter', 'Holaway', '7556 Arrowhead St.', 'Cumberland', 'RI', '02864', '(446) 396-6785'),
	('Wilfred', 'Vise', '77 West Surrey Street', 'Oswego', 'NY', '13126', '(834) 727-1001'),
	('Maritza', 'Tilton', '939 Linda Rd.', 'Burke', 'VA', '22015', '(446) 351-6860'),
	('Joleen', 'Tison', '87 Queen St.', 'Drexel Hill', 'PA', '19026', '(231) 893-2755'),
    ('Margaret', 'Donin', '123 Main St.', 'Brooklyn', 'NY', '11229', '(123) 555-0987');

INSERT INTO `Reservation` (`GuestId`, `Adult`, `Children`, `Start`, `End`, `RoomId`, `Price`)
VALUES(1, 1, 0, '2023/2/2', '2023/2/4', '308', '299.98'),
	(2, 2, 1, '2023/2/5', '2023/2/10', '203', '999.95'),
	(3, 2, 0, '2023/2/22', '2023/2/24', '305', '349.98'),
	(4, 2, 2, '2023/3/6', '2023/3/7', '201', '199.99'),
	(12, 1, 1, '2023/3/17', '2023/3/20', '307', '524.97'),
	(5, 3, 0, '2023/3/18', '2023/3/23', '302', '924.95'),
	(6, 2, 2, '2023/3/29', '2023/3/31', '202', '349.98'),
	(7, 2, 0, '2023/3/31', '2023/4/5', '304', '874.95'),
	(8, 1, 0, '2023/4/9', '2023/4/13', '301', '799.96'),
	(9, 1, 1, '2023/4/23', '2023/4/24', '207', '174.99'),
	(10, 2, 4, '2023/5/30', '2023/6/2', '401', '1199.97'),
	(11, 2, 0, '2023/6/10', '2023/6/14', '206', '599.96'),
	(11, 1, 0, '2023/6/10', '2023/6/14', '208', '599.96'),
	(5, 3, 0, '2023/6/17', '2023/6/18', '304', '184.99'),
	(12, 2, 0, '2023/6/28', '2023/7/2', '205', '699.96'),
	(8, 3, 1, '2023/7/13', '2023/7/14', '204', '184.99'),
	(9, 4, 2, '2023/7/18', '2023/7/21', '401', '1259.97'),
	(2, 2, 1, '2023/7/28', '2023/7/29', '303', '199.99'),
	(2, 1, 0, '2023/8/30', '2023/9/1', '305', '349.98'),
	(1, 2, 0, '2023/9/16', '2023/9/17', '208', '149.99'),
	(4, 2, 2, '2023/9/13', '2023/9/15', '203', '399.98'),
	(3, 2, 2, '2023/11/22', '2023/11/25', '401', '1199.97'),
	(1, 2, 0, '2023/11/22', '2023/11/25', '206', '449.97'),
	(1, 2, 2, '2023/11/22', '2023/11/25', '301', '599.97'),
	(10, 2, 0, '2023/12/24', '2023/12/28', '302', '699.96');

-- Create SQL statements that will delete Jeremiah Pendergrass and his reservations from the database

DELETE FROM `Reservation`
WHERE `GuestId` = 
	(SELECT
		`GuestId`
	FROM `Guest`
    WHERE `FirstName` = 'Jeremiah'
		AND `LastName` = 'Pendergrass');
    
SET SQL_SAFE_UPDATES = 0;

DELETE FROM `Guest`
WHERE `FirstName` = 'Jeremiah'
		AND `LastName` = 'Pendergrass';

SET SQL_SAFE_UPDATES = 1;
