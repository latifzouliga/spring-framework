create table departments(
    department varchar(250),
    division varchar(100),
    primary key (department)
);


-- create table regions(
--     region_id int,
--     region varchar(20),
--     country varchar(20),
--     primary key (region_id)
-- );

create table employees(
    employee_id int,
    first_name varchar(20),
    last_name varchar(20),
    email varchar(50),
    hire_date date,
--     department varchar(20),
    gender varchar(1),
    salary int,
--     region_id int,
    primary key (employee_id)
);