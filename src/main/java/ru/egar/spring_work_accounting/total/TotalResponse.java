package ru.egar.spring_work_accounting.total;

import lombok.Builder;
import lombok.Data;
import ru.egar.spring_work_accounting.employee.EmployeeDto;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class TotalResponse {

    private UUID id;
    private int totalWorkedTime;
    private int kpiPercentage;
    private float totalSalary;
    private LocalDate date;
    private EmployeeDto employee;

}
