package ru.egar.spring_work_accounting.compute_strategy;

import ru.egar.spring_work_accounting.rate.Rate;

public class ComputeOverTimeStrategy implements ComputeSalaryStrategy {
    @Override
    public float computeSalary(Rate rate, int hours) {
        return hours * rate.getOverTimeRate();
    }
}
