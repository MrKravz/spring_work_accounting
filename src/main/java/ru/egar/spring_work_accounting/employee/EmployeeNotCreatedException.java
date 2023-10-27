package ru.egar.spring_work_accounting.employee;

public class EmployeeNotCreatedException extends EmployeeException {
    public EmployeeNotCreatedException(String message) {
        super(message);
    }
}
