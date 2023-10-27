package ru.egar.spring_work_accounting.bonus;

import ru.egar.spring_work_accounting.abstraction.exceptions.EntityStateRelatedException;

public class BonusStateException extends EntityStateRelatedException {
    public BonusStateException(String message) {
        super(message);
    }
}
