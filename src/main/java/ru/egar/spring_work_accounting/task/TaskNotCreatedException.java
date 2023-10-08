package ru.egar.spring_work_accounting.task;

public class TaskNotCreatedException extends RuntimeException {
    public TaskNotCreatedException(String message) {
        super(message);
    }
}
