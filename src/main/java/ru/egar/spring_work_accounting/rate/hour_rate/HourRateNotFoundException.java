package ru.egar.spring_work_accounting.rate.hour_rate;

public class HourRateNotFoundException extends RuntimeException {
    public HourRateNotFoundException() {
        super("Hour rate with provided id not found");
    }

}
