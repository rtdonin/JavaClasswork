USE Flooring;

INSERT INTO `State` (`StateAbbreviation`, `Name`, `TaxRate`) VALUES 
	('TX', 'Texas', 4.45),
	('WA', 'Washington', 9.25),
	('KY', 'Kentucky', 6.00),
	('CA', 'California', 25.00);

INSERT INTO `Product` (`Type`, `CostPerSquareFoot`, `LaborPerSquareFoot`) VALUES
	('Carpet', 2.25, 2.10),
    ('Laminate', 1.75, 2.10),
    ('Tile', 3.50, 4.15),
    ('Wood', 5.15, 4.75);

INSERT INTO `Cost` (`MaterialCost`, `LaborCost`, `Tax`, `Total`) VALUES
	(871.50, 1033.35, 476.21, 2381.06),
    (1251.45, 1154.25, 216.51, 2622.21),
    (488.25, 455.70, 56.64, 1000.59);
    
INSERT INTO `Order` (`Name`, `Date`, `StateAbbreviation`, `ProductId`, `Area`, `CostId`) VALUES
	('Ada Lovelace', '2013-06-12', 'CA', 3, 249.00, 1),
    ('Doctor Who', '2013-06-13', 'WA', 4, 243.00, 2),
    ('Albert Einstein', '2013-06-13', 'KY', 1,217.00, 3);