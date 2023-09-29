package ru.egar.spring_work_accounting.define.payment_strategy;

import ru.egar.spring_work_accounting.rate.hour_rate.HourRate;

public interface ComputePaymentStrategy {

    float computeSalary(HourRate hourRate, int hours);

}
