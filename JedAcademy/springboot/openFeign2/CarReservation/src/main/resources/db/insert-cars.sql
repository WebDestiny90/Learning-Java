INSERT INTO cars (brand, model, manufacture_year, color, plate, type, transmission, fuel_type, seats, doors, engine_volume, horsepower, fuel_consumption, air_conditioner, gps, daily_price, availability_status, created_at, updated_at)
VALUES
('Toyota', 'Camry', 2021, 'WHITE', '90-AB-001', 'SEDAN', 'AUTOMATIC', 'PETROL', 5, 4, 2.5, 181, 7.5, TRUE, TRUE, 70.0, 'AVAILABLE', NOW(), NOW()),
('Toyota', 'Corolla', 2020, 'BLACK', '90-AB-002', 'SEDAN', 'AUTOMATIC', 'PETROL', 5, 4, 1.8, 140, 6.8, TRUE, TRUE, 60.0, 'AVAILABLE', NOW(), NOW()),
('Toyota', 'RAV4', 2022, 'BLUE', '90-AB-003', 'SUV', 'AUTOMATIC', 'HYBRID', 5, 4, 2.5, 219, 5.9, TRUE, TRUE, 95.0, 'RESERVED',  NOW(), NOW()),
('Hyundai', 'Elantra', 2021, 'GRAY', '10-AA-111', 'SEDAN', 'AUTOMATIC', 'PETROL', 5, 4, 2.0, 156, 7.2, TRUE, TRUE, 65.0, 'AVAILABLE', NOW(), NOW()),
('Hyundai', 'Tucson', 2022, 'WHITE', '10-AA-112', 'SUV', 'AUTOMATIC', 'DIESEL', 5, 4, 2.0, 185, 6.9, TRUE, TRUE, 90.0, 'AVAILABLE', NOW(), NOW()),
('BMW', 'X5', 2021, 'BLACK', '99-BB-500', 'SUV', 'AUTOMATIC', 'DIESEL', 5, 4, 3.0, 286, 8.5, TRUE, TRUE, 150.0, 'MAINTENANCE', NOW(), NOW()),
('BMW', '330i', 2020, 'BLUE', '99-BB-501', 'SEDAN', 'AUTOMATIC', 'PETROL', 5, 4, 2.0, 258, 7.0, TRUE, TRUE, 120.0, 'AVAILABLE', NOW(), NOW()),
('Mercedes', 'C200', 2022, 'SILVER', '99-MC-200', 'SEDAN', 'AUTOMATIC', 'PETROL', 5, 4, 1.5, 204, 6.5, TRUE, TRUE, 130.0, 'RESERVED', NOW(), NOW()),
('Mercedes', 'E300', 2023, 'WHITE', '99-MC-300', 'SEDAN', 'AUTOMATIC', 'HYBRID', 5, 4, 2.0, 258, 6.1, TRUE, TRUE, 180.0, 'AVAILABLE', NOW(), NOW()),
('Mercedes', 'GLA200', 2021, 'RED', '99-MC-400', 'SUV', 'AUTOMATIC', 'PETROL', 5, 4, 1.3, 163, 6.8, TRUE, TRUE, 110.0, 'AVAILABLE',  NOW(), NOW()),

('Kia', 'Sportage', 2022, 'WHITE', '10-KI-100', 'SUV', 'AUTOMATIC', 'PETROL', 5, 4, 2.0, 155, 7.5, TRUE, TRUE, 80.0, 'AVAILABLE',  NOW(), NOW()),
('Kia', 'Cerato', 2021, 'BLACK', '10-KI-101', 'SEDAN', 'AUTOMATIC', 'PETROL', 5, 4, 1.6, 128, 7.0, TRUE, TRUE, 60.0, 'AVAILABLE',  NOW(), NOW()),
('Kia', 'Rio', 2019, 'GRAY', '10-KI-102', 'HATCHBACK', 'AUTOMATIC', 'PETROL', 5, 4, 1.4, 100, 6.2, TRUE, FALSE, 50.0, 'AVAILABLE',  NOW(), NOW()),
('Audi', 'A4', 2021, 'BLACK', '77-AU-400', 'SEDAN', 'AUTOMATIC', 'PETROL', 5, 4, 2.0, 190, 6.9, TRUE, TRUE, 130.0, 'AVAILABLE', NOW(), NOW()),
('Audi', 'Q5', 2022, 'WHITE', '77-AU-401', 'SUV', 'AUTOMATIC', 'HYBRID', 5, 4, 2.0, 265, 6.3, TRUE, TRUE, 160.0, 'RESERVED',  NOW(), NOW()),

('Volkswagen', 'Passat', 2021, 'BLUE', '99-VW-900', 'SEDAN', 'AUTOMATIC', 'PETROL', 5, 4, 2.0, 190, 6.5, TRUE, TRUE, 100.0, 'AVAILABLE',  NOW(), NOW()),
('Volkswagen', 'Golf', 2020, 'RED', '99-VW-901', 'HATCHBACK', 'AUTOMATIC', 'PETROL', 5, 4, 1.5, 150, 5.9, TRUE, TRUE, 80.0, 'AVAILABLE',  NOW(), NOW()),
('Volkswagen', 'Tiguan', 2022, 'WHITE', '99-VW-902', 'SUV', 'AUTOMATIC', 'PETROL', 5, 4, 2.0, 190, 7.1, TRUE, TRUE, 120.0, 'AVAILABLE',  NOW(), NOW()),

('Nissan', 'X-Trail', 2021, 'SILVER', '10-NI-300', 'SUV', 'AUTOMATIC', 'PETROL', 5, 4, 2.5, 170, 7.8, TRUE, TRUE, 85.0, 'AVAILABLE',  NOW(), NOW()),
('Nissan', 'Altima', 2020, 'BLACK', '10-NI-301', 'SEDAN', 'AUTOMATIC', 'PETROL', 5, 4, 2.0, 188, 6.8, TRUE, TRUE, 75.0, 'AVAILABLE',  NOW(), NOW()),

('Chevrolet', 'Cruze', 2019, 'RED', '77-CH-100', 'SEDAN', 'AUTOMATIC', 'PETROL', 5, 4, 1.8, 140, 7.4, TRUE, TRUE, 55.0, 'AVAILABLE',  NOW(), NOW()),
('Chevrolet', 'Captiva', 2021, 'WHITE', '77-CH-101', 'SUV', 'AUTOMATIC', 'DIESEL', 7, 4, 2.0, 170, 7.8, TRUE, TRUE, 85.0, 'AVAILABLE',  NOW(), NOW()),
('Chevrolet', 'Spark', 2020, 'YELLOW', '77-CH-102', 'HATCHBACK', 'MANUAL', 'PETROL', 4, 4, 1.2, 85, 5.5, FALSE, FALSE, 40.0, 'AVAILABLE',  NOW(), NOW()),

('Ford', 'Focus', 2020, 'GRAY', '10-FD-200', 'HATCHBACK', 'MANUAL', 'PETROL', 5, 4, 1.5, 120, 6.4, TRUE, TRUE, 50.0, 'AVAILABLE',  NOW(), NOW()),
('Ford', 'Escape', 2021, 'WHITE', '10-FD-201', 'SUV', 'AUTOMATIC', 'HYBRID', 5, 4, 2.5, 200, 6.1, TRUE, TRUE, 95.0, 'AVAILABLE',  NOW(), NOW()),
('Ford', 'Mustang', 2022, 'RED', '10-FD-202', 'COUPE', 'MANUAL', 'PETROL', 4, 2, 5.0, 450, 11.0, TRUE, FALSE, 200.0, 'AVAILABLE',  NOW(), NOW()),

('Lexus', 'RX350', 2022, 'BLACK', '99-LX-500', 'SUV', 'AUTOMATIC', 'HYBRID', 5, 4, 3.5, 308, 7.2, TRUE, TRUE, 180.0, 'AVAILABLE',  NOW(), NOW()),
('Lexus', 'ES300', 2021, 'WHITE', '99-LX-501', 'SEDAN', 'AUTOMATIC', 'HYBRID', 5, 4, 2.5, 215, 6.0, TRUE, TRUE, 160.0, 'RESERVED',  NOW(), NOW()),

('Honda', 'Civic', 2021, 'GRAY', '90-HN-100', 'SEDAN', 'AUTOMATIC', 'PETROL', 5, 4, 1.8, 140, 6.5, TRUE, TRUE, 65.0, 'AVAILABLE',  NOW(), NOW()),
('Honda', 'Accord', 2022, 'BLACK', '90-HN-101', 'SEDAN', 'AUTOMATIC', 'HYBRID', 5, 4, 2.0, 212, 6.1, TRUE, TRUE, 100.0, 'AVAILABLE',  NOW(), NOW()),
('Honda', 'CR-V', 2021, 'WHITE', '90-HN-102', 'SUV', 'AUTOMATIC', 'PETROL', 5, 4, 2.4, 184, 7.4, TRUE, TRUE, 85.0, 'MAINTENANCE',  NOW(), NOW()),

('Mazda', 'CX-5', 2021, 'RED', '10-MZ-100', 'SUV', 'AUTOMATIC', 'PETROL', 5, 4, 2.5, 187, 7.2, TRUE, TRUE, 90.0, 'AVAILABLE',  NOW(), NOW()),
('Mazda', '3', 2020, 'BLUE', '10-MZ-101', 'SEDAN', 'AUTOMATIC', 'PETROL', 5, 4, 2.0, 155, 6.8, TRUE, TRUE, 60.0, 'AVAILABLE',  NOW(), NOW()),

('Tesla', 'Model 3', 2023, 'WHITE', '77-TS-100', 'SEDAN', 'AUTOMATIC', 'ELECTRIC', 5, 4, 0.0, 283, 0.0, TRUE, TRUE, 200.0, 'AVAILABLE',  NOW(), NOW()),
('Tesla', 'Model Y', 2023, 'BLACK', '77-TS-101', 'SUV', 'AUTOMATIC', 'ELECTRIC', 5, 4, 0.0, 345, 0.0, TRUE, TRUE, 220.0, 'AVAILABLE',  NOW(), NOW()),

('Peugeot', '3008', 2021, 'WHITE', '10-PG-100', 'SUV', 'AUTOMATIC', 'DIESEL', 5, 4, 2.0, 177, 6.4, TRUE, TRUE, 95.0, 'AVAILABLE',  NOW(), NOW()),
('Peugeot', '508', 2020, 'GRAY', '10-PG-101', 'SEDAN', 'AUTOMATIC', 'PETROL', 5, 4, 1.6, 160, 6.2, TRUE, TRUE, 80.0, 'AVAILABLE',  NOW(), NOW()),

('Renault', 'Megane', 2019, 'BLUE', '90-RN-100', 'SEDAN', 'MANUAL', 'PETROL', 5, 4, 1.6, 115, 6.5, TRUE, FALSE, 50.0, 'AVAILABLE',  NOW(), NOW()),
('Renault', 'Duster', 2021, 'WHITE', '90-RN-101', 'SUV', 'MANUAL', 'DIESEL', 5, 4, 1.5, 110, 5.8, TRUE, TRUE, 70.0, 'AVAILABLE',  NOW(), NOW()),

('Subaru', 'Forester', 2022, 'GREEN', '99-SB-100', 'SUV', 'AUTOMATIC', 'PETROL', 5, 4, 2.5, 182, 7.3, TRUE, TRUE, 100.0, 'AVAILABLE',  NOW(), NOW()),
('Subaru', 'Outback', 2022, 'GRAY', '99-SB-101', 'SUV', 'AUTOMATIC', 'PETROL', 5, 4, 2.5, 188, 7.5, TRUE, TRUE, 110.0, 'AVAILABLE',  NOW(), NOW()),

('Jeep', 'Compass', 2022, 'BLACK', '10-JP-100', 'SUV', 'AUTOMATIC', 'PETROL', 5, 4, 2.4, 180, 8.0, TRUE, TRUE, 120.0, 'AVAILABLE',  NOW(), NOW()),
('Jeep', 'Wrangler', 2023, 'RED', '10-JP-101', 'SUV', 'MANUAL', 'PETROL', 4, 2, 3.6, 285, 10.5, TRUE, FALSE, 180.0, 'AVAILABLE',  NOW(), NOW());
