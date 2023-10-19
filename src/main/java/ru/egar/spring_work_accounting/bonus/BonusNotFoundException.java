package ru.egar.spring_work_accounting.bonus;

public class BonusNotFoundException extends RuntimeException {
    public BonusNotFoundException() {
        super("Bonus with provided data not found");
    }
}
