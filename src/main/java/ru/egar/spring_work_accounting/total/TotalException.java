package ru.egar.spring_work_accounting.total;

import ru.egar.spring_work_accounting.abstraction.exceptions.EntityRelatedException;

public class TotalException extends EntityRelatedException {
    public TotalException(String message) {
        super(message);
    }
}
