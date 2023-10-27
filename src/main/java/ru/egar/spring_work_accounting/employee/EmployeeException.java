package ru.egar.spring_work_accounting.employee;

import ru.egar.spring_work_accounting.abstraction.exceptions.EntityRelatedException;

public class EmployeeException extends EntityRelatedException {
    public EmployeeException(String message) {
        super(message);
    }
}
