/*CREATE SCHEMA volvocars_congestion_tax
go

CREATE TABLE city(
    id INT PRIMARY KEY IDENTITY,
    name VARCHAR(200) NOT NULL);

CREATE TABLE congestion_tax(
                                       id INT PRIMARY KEY IDENTITY,
                                       city_id INT NOT NULL,
                                       description VARCHAR(200),
                                       created_at DATETIME2 NOT NULL,
                                       time_range VARCHAR (11),
                                       float amount
);*/

insert into city (id, name)
values (1, 'Gothenburg');

insert into Vehicle(id, Is_Tax_Exempt, Vehicle_Type)
values (1, false, 'CAR');
insert into Vehicle(id, Vehicle_Type, Is_Tax_Exempt)
values (2, false, 'MOTOR_BIKE');
insert into Vehicle(id, Vehicle_Type, Is_Tax_Exempt)
values (3, true, 'EMERGENCY_VEHICLES');
insert into Vehicle(id, Vehicle_Type, Is_Tax_Exempt)
values (4, true, 'BUSSES');
insert into Vehicle(id, Vehicle_Type, Is_Tax_Exempt)
values (5 true, 'DIPLOMAT_VEHICLES',);
insert into Vehicle(id, Vehicle_Type, Is_Tax_Exempt)
values (6, true, 'MOTORCYCLES');
insert into Vehicle(id, Vehicle_Type, Is_Tax_Exempt)
values (7, true, 'MILITARY_VEHICLES');
insert into Vehicle(id, Vehicle_Type, Is_Tax_Exempt)
values (8, true, 'FOREIGN_VEHICLES');

insert into Congestion_Tax(id, start_time, end_time, amount, city_id)
values (1, '06:00', '06:29', 8, 1);
insert into Congestion_Tax(id, start_time, end_time, amount, city_id)
values (2, '06:30', '06:59', 13, 1);
insert into Congestion_Tax(id, start_time, end_time, amount, city_id)
values (3, '07:00', '07:59', 18, 1);
insert into Congestion_Tax(id, start_time, end_time, amount, city_id)
values (4, '08:00', '08:29', 13, 1);
insert into Congestion_Tax(id, start_time, end_time, amount, city_id)
values (5, '08:30', '14:59', 8, 1);
insert into Congestion_Tax(id, start_time, end_time, amount, city_id)
values (6, '15:00', '15:29', 13, 1);
insert into Congestion_Tax(id, start_time, end_time, amount, city_id)
values (7, '15:30', '16:59', 18, 1);
insert into Congestion_Tax(id, start_time, end_time, amount, city_id)
values (8, '17:00', '17:59', 13, 1);
insert into Congestion_Tax(id, start_time, end_time, amount, city_id)
values (9, '18:00', '18:29', 8, 1);
insert into Congestion_Tax(id, start_time, end_time, amount, city_id)
values (10, '18:30', '05:59', 0, 1);

/* holiday containt 1 day before*/
insert into Entity_Attribute(id, name, value)
values (1, 'Weekend', 3, true);
insert into Entity_Attribute(id, name, value)
values (2, 'Holiday', 4, true);
insert into Entity_Attribute(id, name, value)
values (4, 'Month', 30, true);

insert into Tax_Free_Times(id, description)
values (1, 'weekend');
insert into Tax_Free_Times(id, description)
values (1, 'weekend');

insert into Tax_Free_Times_Attributes(tax_free_tımes_id, attributes_id)
values (1, 1);







