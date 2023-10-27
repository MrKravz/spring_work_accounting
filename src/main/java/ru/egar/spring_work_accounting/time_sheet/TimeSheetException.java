package ru.egar.spring_work_accounting.time_sheet;

import ru.egar.spring_work_accounting.abstraction.exceptions.EntityRelatedException;

public class TimeSheetException extends EntityRelatedException {
    public TimeSheetException(String message) {
        super(message);
    }
}
