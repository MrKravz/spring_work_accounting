package ru.egar.spring_work_accounting.bonus.bonus_interaction;

import ru.egar.spring_work_accounting.bonus.BonusStateException;

public class BonusAlreadySetException extends BonusStateException {
    public BonusAlreadySetException(String message) {
        super(message);
    }
}
