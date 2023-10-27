package ru.egar.spring_work_accounting.bonus;

import ru.egar.spring_work_accounting.abstraction.exceptions.EntityRelatedException;

public class BonusException extends EntityRelatedException {
    public BonusException(String message) {
        super(message);
    }
}
