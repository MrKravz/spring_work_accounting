package ru.egar.spring_work_accounting.rate.kpi_rate;

public class KpiRateNotUpdatedException extends RuntimeException {
    public KpiRateNotUpdatedException(String message) {
        super(message);
    }
}
