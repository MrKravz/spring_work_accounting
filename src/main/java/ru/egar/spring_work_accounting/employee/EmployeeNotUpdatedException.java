package ru.egar.spring_work_accounting.employee;

public class EmployeeNotUpdatedException extends RuntimeException {
    public EmployeeNotUpdatedException(String message) {
        super(message);
    }
}
