DROP TABLE IF EXISTS employees_totals;
DROP TABLE IF EXISTS employees_time_sheets;
DROP TABLE IF EXISTS employees_tasks;
DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS totals;
DROP TABLE IF EXISTS time_sheets;
DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS kpi_rates;
DROP TABLE IF EXISTS hour_rates;


CREATE TABLE hour_rates
(
    id                 BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    turnout_rate       FLOAT   NOT NULL,
    vacation_rate      FLOAT   NOT NULL,
    sick_days_rate     FLOAT   NOT NULL,
    business_trip_rate FLOAT   NOT NULL,
    absence_rate       FLOAT   NOT NULL,
    over_time_rate     FLOAT   NOT NULL,
    position           VARCHAR NOT NULL,
    grade              VARCHAR NOT NULL
);

CREATE TABLE kpi_rates
(
    id                          BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    agreed_salary               FLOAT   NOT NULL,
    agreed_tasks_point_quantity FLOAT   NOT NULL,
    position                    VARCHAR NOT NULL,
    grade                       VARCHAR NOT NULL
);

CREATE TABLE employees
(
    id                BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name              VARCHAR NOT NULL,
    date_of_birthday  DATE    NOT NULL,
    employee_position VARCHAR NOT NULL,
    employee_grade    VARCHAR NOT NULL,
    payment_system    VARCHAR NOT NULL,
    hour_rate_id      BIGINT REFERENCES hour_rates (id),
    kpi_rate_id       BIGINT REFERENCES hour_rates (id)
);

CREATE TABLE tasks
(
    id                 BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    short_name         VARCHAR NOT NULL,
    description        VARCHAR NOT NULL,
    date_time_start    TIMESTAMP,
    date_time_end      TIMESTAMP,
    task_points_number INT     NOT NULL,
    task_status        VARCHAR NOT NULL
);

CREATE TABLE time_sheets
(
    id          BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    time_span   int     NOT NULL,
    time_status VARCHAR NOT NULL,
    date        DATE    NOT NULL
);

CREATE TABLE totals
(
    id                BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    total_worked_time INT   NOT NULL,
    kpi_percentage    INT   NOT NULL,
    total_salary      FLOAT NOT NULL,
    date              DATE  NOT NULL
);

CREATE TABLE accounts
(
    id       BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    login    VARCHAR NOT NULL,
    password VARCHAR NOT NULL,
    role     VARCHAR NOT NULL
);

CREATE TABLE employees_tasks
(
    employee_id BIGINT REFERENCES employees (id),
    task_id     BIGINT REFERENCES tasks (id) UNIQUE
);

CREATE TABLE employees_time_sheets
(
    employee_id   BIGINT REFERENCES employees (id),
    time_sheet_id BIGINT REFERENCES time_sheets (id) UNIQUE
);

CREATE TABLE employees_totals
(
    employee_id BIGINT REFERENCES employees (id),
    total_id    BIGINT REFERENCES totals (id) UNIQUE
);