package ru.egar.spring_work_accounting.bonus.bonus_interaction;

import ru.egar.spring_work_accounting.bonus.BonusStateException;

public class BonusIsNotSetException extends BonusStateException {
    public BonusIsNotSetException(String message) {
        super(message);
    }
}
