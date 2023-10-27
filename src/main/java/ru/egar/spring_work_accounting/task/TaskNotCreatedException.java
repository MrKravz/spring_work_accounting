package ru.egar.spring_work_accounting.task;

public class TaskNotCreatedException extends TaskException {
    public TaskNotCreatedException(String message) {
        super(message);
    }
}
