package ru.egar.spring_work_accounting.rate.hour_rate;

public class HourRateNotUpdatedException extends RuntimeException {
    public HourRateNotUpdatedException(String message) {
        super(message);
    }
}
