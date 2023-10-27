package ru.egar.spring_work_accounting.rate.kpi_rate;

public class KpiRateNotFoundException extends KpiRateException {
    public KpiRateNotFoundException() {
        super("Kpi rate with provided id not found");
    }

}
