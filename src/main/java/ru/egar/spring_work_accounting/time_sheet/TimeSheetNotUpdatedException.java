package ru.egar.spring_work_accounting.time_sheet;

public class TimeSheetNotUpdatedException extends RuntimeException {
    public TimeSheetNotUpdatedException(String message) {
        super(message);
    }
}
