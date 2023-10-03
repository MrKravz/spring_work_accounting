package ru.egar.spring_work_accounting.employee.employee_interaction;

public class TaskIsAlreadyStartedException extends RuntimeException {

    public TaskIsAlreadyStartedException(String message) {
        super(message);
    }

}
