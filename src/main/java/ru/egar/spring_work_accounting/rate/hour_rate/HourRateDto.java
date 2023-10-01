package ru.egar.spring_work_accounting.rate.hour_rate;

import lombok.Data;
import ru.egar.spring_work_accounting.employee.EmployeeDto;

import java.util.UUID;

@Data
public class HourRateDto {

    private UUID id;
    private float turnoutRate;
    private float vacationRate;
    private float sickDaysRate;
    private float businessTripRate;
    private float absenceRate;
    private float overTimeRate;
    private EmployeeDto employee;

}
