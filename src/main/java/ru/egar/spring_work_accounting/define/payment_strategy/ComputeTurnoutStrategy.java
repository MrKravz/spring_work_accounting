package ru.egar.spring_work_accounting.define.payment_strategy;


import ru.egar.spring_work_accounting.hour_rate.HourRate;

public class ComputeTurnoutStrategy implements ComputePaymentStrategy {

    @Override
    public float computeSalary(HourRate hourRate, int hours) {
        return hours * hourRate.getTurnoutRate();
    }

}
