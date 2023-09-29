package ru.egar.spring_work_accounting.rate.kpi_rate;

import lombok.Data;

import java.util.UUID;

@Data
public class KpiRateDto {
    private UUID id;
    private float agreedSalary;
    private int agreedTasksPointQuantity;
}
