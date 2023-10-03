package ru.egar.spring_work_accounting.rate.kpi_rate;

import lombok.Builder;
import lombok.Data;
import ru.egar.spring_work_accounting.employee.EmployeeDto;

import java.util.UUID;

@Data
@Builder
public class KpiRateResponse {

    private UUID id;
    private float agreedSalary;
    private int agreedTasksPointQuantity;
    private EmployeeDto employee;

}
