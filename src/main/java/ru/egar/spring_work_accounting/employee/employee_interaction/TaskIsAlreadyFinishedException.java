package ru.egar.spring_work_accounting.employee.employee_interaction;

public class TaskIsAlreadyFinishedException extends RuntimeException {
    public TaskIsAlreadyFinishedException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
