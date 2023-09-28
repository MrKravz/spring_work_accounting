package ru.egar.spring_work_accounting.employee;

import lombok.Data;
import ru.egar.spring_work_accounting.hour_rate.HourRateDto;
import ru.egar.spring_work_accounting.hour_rate.PaymentSystem;
import ru.egar.spring_work_accounting.kpi_rate.KpiRateDto;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class EmployeeDto {
    private UUID id;
    private String name;
    private LocalDate dateOfBirthDay;
    private Position employeePosition;
    private Grade employeeGrade;
    private PaymentSystem paymentSystem;
    private HourRateDto hourRate;
    private KpiRateDto kpiRate;
}
