package ru.egar.spring_work_accounting.employee;

import lombok.Builder;
import lombok.Data;
import ru.egar.spring_work_accounting.rate.hour_rate.HourRateDto;
import ru.egar.spring_work_accounting.rate.hour_rate.PaymentSystem;
import ru.egar.spring_work_accounting.rate.kpi_rate.KpiRateDto;

import java.time.LocalDate;

@Data
@Builder
public class EmployeeDto {

    private long id;
    private String name;
    private LocalDate dateOfBirthDay;
    private Position employeePosition;
    private Grade employeeGrade;
    private PaymentSystem paymentSystem;
    private HourRateDto hourRate;
    private KpiRateDto kpiRate;

}
