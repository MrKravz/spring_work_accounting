package ru.egar.spring_work_accounting.define.payment_strategy;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.time_sheet.TimeStatus;

/**
 * Service defines and returns strategy depending on passed
 * status(all strategies must implement ComputeSalaryStrategy).
 **/
@Service
@Transactional(readOnly = true)
public class DefineComputePaymentService {

    public ComputePaymentStrategy defineStrategy(TimeStatus timeStatus) {
        return switch(timeStatus) {
            case Turnout -> new ComputeTurnoutStrategy();
            case BusinessTrip -> new ComputeBusinessTripStrategy();
            case Vacation -> new ComputeVacationStrategy();
            case SickDays -> new ComputeSickDaysStrategy();
            case Absence -> new ComputeAbsenceStrategy();
            case OverTime -> new ComputeOverTimeStrategy();
        };
    }

}
