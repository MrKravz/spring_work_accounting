package ru.egar.spring_work_accounting.task;

import ru.egar.spring_work_accounting.abstraction.exceptions.EntityStateRelatedException;

public class TaskStateException extends EntityStateRelatedException {
    public TaskStateException(String message) {
        super(message);
    }
}
