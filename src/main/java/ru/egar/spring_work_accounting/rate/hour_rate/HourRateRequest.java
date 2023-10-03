package ru.egar.spring_work_accounting.rate.hour_rate;

import lombok.Builder;
import lombok.Data;
import ru.egar.spring_work_accounting.employee.EmployeeDto;

@Data
@Builder
public class HourRateRequest {

    private float turnoutRate;
    private float vacationRate;
    private float sickDaysRate;
    private float businessTripRate;
    private float absenceRate;
    private float overTimeRate;
    private EmployeeDto employee;

}
