package ru.egar.spring_work_accounting.define.payment_strategy;

import ru.egar.spring_work_accounting.rate.hour_rate.HourRate;

public class ComputeVacationStrategy implements ComputePaymentStrategy {

    @Override
    public float computeSalary(HourRate hourRate, int hours) {
        return hours * hourRate.getVacationRate();
    }

}
