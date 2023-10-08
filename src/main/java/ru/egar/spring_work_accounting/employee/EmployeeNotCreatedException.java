package ru.egar.spring_work_accounting.employee;

public class EmployeeNotCreatedException extends RuntimeException {
    public EmployeeNotCreatedException(String message) {
        super(message);
    }
}
