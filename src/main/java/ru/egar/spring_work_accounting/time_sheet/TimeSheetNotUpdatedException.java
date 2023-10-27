package ru.egar.spring_work_accounting.time_sheet;

public class TimeSheetNotUpdatedException extends TimeSheetException {
    public TimeSheetNotUpdatedException(String message) {
        super(message);
    }
}
