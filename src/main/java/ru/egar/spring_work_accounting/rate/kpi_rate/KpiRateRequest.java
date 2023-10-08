package ru.egar.spring_work_accounting.rate.kpi_rate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Data;
import ru.egar.spring_work_accounting.employee.Grade;
import ru.egar.spring_work_accounting.employee.Position;

@Data
@Builder
public class KpiRateRequest {

    @Min(value = 1000, message = "Minimal agreed salary is 1000")
    private float agreedSalary;

    @Min(value = 100, message = "Minimal task point number is 100")
    @Max(value = 350, message = "Maximum task point number is 350")
    private int agreedTasksPointQuantity;

    private Position position;

    private Grade grade;

}
