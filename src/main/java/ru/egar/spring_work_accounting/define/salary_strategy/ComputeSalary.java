package ru.egar.spring_work_accounting.define.salary_strategy;

import ru.egar.spring_work_accounting.employee.Employee;

import java.time.LocalDate;

public interface ComputeSalary {

    float computeSalary(Employee employee, LocalDate dateStart, LocalDate dateEnd);

}
