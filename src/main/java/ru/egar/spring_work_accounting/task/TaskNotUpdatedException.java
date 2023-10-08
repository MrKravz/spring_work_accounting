package ru.egar.spring_work_accounting.task;

public class TaskNotUpdatedException extends RuntimeException {
    public TaskNotUpdatedException(String message) {
        super(message);
    }
}
