package ru.egar.spring_work_accounting.task;

import ru.egar.spring_work_accounting.abstraction.exceptions.EntityRelatedException;

public class TaskException extends EntityRelatedException {
    public TaskException(String message) {
        super(message);
    }
}
