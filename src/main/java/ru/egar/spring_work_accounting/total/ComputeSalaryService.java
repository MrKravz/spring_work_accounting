package ru.egar.spring_work_accounting.total;

import ru.egar.spring_work_accounting.rate.Rate;
import ru.egar.spring_work_accounting.time_sheet.TimeStatus;

/**
 * Service computes and returns salary by rate, time status and number of hours spent.
 * Serves as sub service for ComputeTotalServiceImpl.
 * Uses DefineComputeStrategyService for computing depending on time status.
 **/
class ComputeSalaryService {

    private final DefineComputeStrategyService defineComputeStrategyService;

    public ComputeSalaryService(DefineComputeStrategyService defineComputeStrategyService) {
        this.defineComputeStrategyService = defineComputeStrategyService;
    }

    public Float computeHoursSalary(Rate rate, int hours, TimeStatus timeStatus) {
        var strategy = defineComputeStrategyService.defineComputeStrategy(timeStatus);
        return strategy.computeSalary(rate, hours);
    }

}
