package ru.egar.spring_work_accounting.task;

public class TaskNotFoundException extends TaskException {
    public TaskNotFoundException() {
        super("Time sheet with provided id not found");
    }
}
