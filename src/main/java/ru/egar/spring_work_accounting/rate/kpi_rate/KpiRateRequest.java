package ru.egar.spring_work_accounting.rate.kpi_rate;

import lombok.Builder;
import lombok.Data;
import ru.egar.spring_work_accounting.employee.EmployeeDto;

@Data
@Builder
public class KpiRateRequest {

    private float agreedSalary;
    private int agreedTasksPointQuantity;
    private EmployeeDto employee;

}
