package ru.egar.spring_work_accounting.bonus;

public class BonusNotCreatedException extends RuntimeException {
    public BonusNotCreatedException(String message) {
        super(message);
    }
}
