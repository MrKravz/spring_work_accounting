package ru.egar.spring_work_accounting.define.payment_strategy;

import ru.egar.spring_work_accounting.rate.Rate;

public class ComputeAbsenceStrategy implements ComputePaymentStrategy {

    @Override
    public float computeSalary(Rate rate, int hours) {
        return hours * rate.getAbsenceRate();
    }

}
