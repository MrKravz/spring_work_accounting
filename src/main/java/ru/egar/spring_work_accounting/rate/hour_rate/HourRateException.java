package ru.egar.spring_work_accounting.rate.hour_rate;

import ru.egar.spring_work_accounting.abstraction.exceptions.EntityRelatedException;

public class HourRateException extends EntityRelatedException {
    public HourRateException(String message) {
        super(message);
    }
}
