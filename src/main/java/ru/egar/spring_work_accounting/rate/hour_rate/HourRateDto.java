package ru.egar.spring_work_accounting.rate.hour_rate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HourRateDto {

    private long id;
    private float turnoutRate;
    private float vacationRate;
    private float sickDaysRate;
    private float businessTripRate;
    private float absenceRate;
    private float overTimeRate;

}
