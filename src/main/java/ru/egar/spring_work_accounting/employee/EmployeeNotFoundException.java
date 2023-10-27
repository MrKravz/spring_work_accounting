package ru.egar.spring_work_accounting.employee;

public class EmployeeNotFoundException extends EmployeeException {

    public EmployeeNotFoundException() {
        super("Employee with provided id not found");
    }

}
