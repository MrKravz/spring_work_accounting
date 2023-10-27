package ru.egar.spring_work_accounting.bonus;

public class BonusNotUpdatedException extends BonusException {
    public BonusNotUpdatedException(String message) {
        super(message);
    }
}
