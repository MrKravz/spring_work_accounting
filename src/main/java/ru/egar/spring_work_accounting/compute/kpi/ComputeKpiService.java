package ru.egar.spring_work_accounting.compute.kpi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.employee.Employee;

import java.time.LocalDate;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ComputeKpiService {
    public int computeKpi(Employee employee, LocalDate dateStart, LocalDate dateEnd) {
        return 0;
    }
}
