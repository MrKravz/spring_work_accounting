package ru.egar.spring_work_accounting.auth;

public class AccountIsAlreadyExistsException extends RuntimeException {
    public AccountIsAlreadyExistsException(String message) {
        super(message);
    }
}
