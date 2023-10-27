package ru.egar.spring_work_accounting.employee.employee_interaction;

import ru.egar.spring_work_accounting.task.TaskStateException;

public class TaskIsAlreadyFinishedException extends TaskStateException {
    public TaskIsAlreadyFinishedException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
