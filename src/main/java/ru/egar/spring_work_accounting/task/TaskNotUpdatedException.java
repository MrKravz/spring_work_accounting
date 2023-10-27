package ru.egar.spring_work_accounting.task;

public class TaskNotUpdatedException extends TaskException {
    public TaskNotUpdatedException(String message) {
        super(message);
    }
}
