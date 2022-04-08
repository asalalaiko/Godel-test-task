CREATE TABLE IF NOT EXISTS employee
(
    employee_id SERIAL PRIMARY KEY,
    first_name varchar(100),
    last_name varchar(100),
    departament_id bigint,
    job_title varchar(100),
    gender varchar(10),
    date_of_birth date
    )
