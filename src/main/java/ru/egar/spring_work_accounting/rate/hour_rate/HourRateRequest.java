package ru.egar.spring_work_accounting.rate.hour_rate;

import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Data;
import ru.egar.spring_work_accounting.employee.Grade;
import ru.egar.spring_work_accounting.employee.Position;

@Data
@Builder
public class HourRateRequest {

    @Min(value = 10, message = "Minimal turnout rate is 10")
    private float turnoutRate;

    @Min(value = 10, message = "Minimal vacation rate is 10")
    private float vacationRate;

    @Min(value = 10, message = "Minimal sick days rate is 10")
    private float sickDaysRate;

    @Min(value = 15, message = "Minimal business trip rate is 15")
    private float businessTripRate;

    @Min(value = 0, message = "Minimal absence rate is 0")
    private float absenceRate;

    @Min(value = 15, message = "Minimal business trip rate is 15")
    private float overTimeRate;

    private Position position;

    private Grade grade;

}
