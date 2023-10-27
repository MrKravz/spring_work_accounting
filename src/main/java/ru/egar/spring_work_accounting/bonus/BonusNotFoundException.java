package ru.egar.spring_work_accounting.bonus;

public class BonusNotFoundException extends BonusException {
    public BonusNotFoundException() {
        super("Bonus with provided data not found");
    }
}
