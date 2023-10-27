package ru.egar.spring_work_accounting.employee.employee_interaction;

import ru.egar.spring_work_accounting.task.TaskStateException;

public class TaskIsAlreadyStartedException extends TaskStateException {

    public TaskIsAlreadyStartedException(String message) {
        super(message);
    }

}
