package ru.egar.spring_work_accounting.define.payment_strategy;


import ru.egar.spring_work_accounting.hour_rate.HourRate;

public class ComputeBusinessTripStrategy implements ComputePaymentStrategy {

    @Override
    public float computeSalary(HourRate hourRate, int hours) {
        return hours * hourRate.getBusinessTripRate();
    }

}
