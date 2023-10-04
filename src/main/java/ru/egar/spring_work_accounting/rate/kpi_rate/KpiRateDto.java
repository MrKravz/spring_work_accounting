package ru.egar.spring_work_accounting.rate.kpi_rate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KpiRateDto {

    private long id;
    private float agreedSalary;
    private int agreedTasksPointQuantity;

}
