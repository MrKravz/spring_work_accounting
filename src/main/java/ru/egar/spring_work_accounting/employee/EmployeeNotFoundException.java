package ru.egar.spring_work_accounting.employee;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException() {
        super("Employee with provided id not found");
    }

}
