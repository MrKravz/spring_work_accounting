package ru.egar.spring_work_accounting.compute_strategy;

import ru.egar.spring_work_accounting.rate.Rate;

public interface ComputeSalaryStrategy {

    float computeSalary(Rate rate, int hours);

}
