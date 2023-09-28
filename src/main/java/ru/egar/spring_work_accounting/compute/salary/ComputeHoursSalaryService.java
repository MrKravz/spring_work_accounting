package ru.egar.spring_work_accounting.compute.salary;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.hour_rate.HourRate;
import ru.egar.spring_work_accounting.time_sheet.TimeStatus;
import ru.egar.spring_work_accounting.define.payment_strategy.DefineComputePaymentService;

/**
 * Service computes and returns salary by rate, time status and number of hours spent.
 * Uses DefineComputeStrategyService for computing depending on time status.
 **/
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ComputeHoursSalaryService {

    private final DefineComputePaymentService defineComputePaymentService;

    public float computeHoursSalary(HourRate hourRate, int hours, TimeStatus timeStatus) {
        var strategy = defineComputePaymentService.defineStrategy(timeStatus);
        return strategy.computeSalary(hourRate, hours);
    }

}
