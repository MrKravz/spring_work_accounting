package ru.egar.spring_work_accounting.rate.hour_rate;

public class HourRateNotCreatedException extends RuntimeException {
    public HourRateNotCreatedException(String message) {
        super(message);
    }
}
