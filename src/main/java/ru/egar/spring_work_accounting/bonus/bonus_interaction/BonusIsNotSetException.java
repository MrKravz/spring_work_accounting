package ru.egar.spring_work_accounting.bonus.bonus_interaction;

public class BonusIsNotSetException extends RuntimeException {
    public BonusIsNotSetException(String message) {
        super(message);
    }
}
