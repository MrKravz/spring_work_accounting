package ru.egar.spring_work_accounting.define.payment_strategy;

import ru.egar.spring_work_accounting.rate.Rate;

public interface ComputePaymentStrategy {

    float computeSalary(Rate rate, int hours);

}
