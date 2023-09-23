package ru.egar.spring_work_accounting.define.salary_strategy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.rate.PaymentSystem;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DefineComputeSalaryService {

    private final ComputeHourlySalaryService computeHourlySalaryService;
    private final ComputeKpiSalaryService computeKpiSalaryService;

    public ComputeSalary defineStrategy(PaymentSystem paymentSystem) {
        return switch (paymentSystem) {
            case KPI_Payment -> computeKpiSalaryService;
            case Hour_Payment -> computeHourlySalaryService;
        };
    }

}
