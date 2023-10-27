package ru.egar.spring_work_accounting.total;

public class TotalNotFoundException extends TotalException {
    public TotalNotFoundException() {
        super("Total with provided id not found");
    }
}
