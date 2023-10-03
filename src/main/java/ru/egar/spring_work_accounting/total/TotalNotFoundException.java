package ru.egar.spring_work_accounting.total;

public class TotalNotFoundException extends RuntimeException {
    public TotalNotFoundException() {
        super("Total with provided id not found");
    }
}
