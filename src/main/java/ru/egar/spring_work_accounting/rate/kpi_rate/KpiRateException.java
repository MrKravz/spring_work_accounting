package ru.egar.spring_work_accounting.rate.kpi_rate;

import ru.egar.spring_work_accounting.abstraction.exceptions.EntityRelatedException;

public class KpiRateException extends EntityRelatedException {
    public KpiRateException(String message) {
        super(message);
    }
}
