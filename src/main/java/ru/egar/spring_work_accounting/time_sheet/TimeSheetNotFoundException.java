package ru.egar.spring_work_accounting.time_sheet;

public class TimeSheetNotFoundException extends RuntimeException {
    public TimeSheetNotFoundException() {
        super("Time sheet with provided id not found");
    }
}
