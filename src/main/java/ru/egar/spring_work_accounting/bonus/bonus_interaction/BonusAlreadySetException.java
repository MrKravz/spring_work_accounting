package ru.egar.spring_work_accounting.bonus.bonus_interaction;

public class BonusAlreadySetException extends RuntimeException {
    public BonusAlreadySetException(String message) {
        super(message);
    }
}