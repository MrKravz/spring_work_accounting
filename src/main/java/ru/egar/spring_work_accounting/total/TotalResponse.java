package ru.egar.spring_work_accounting.total;

import lombok.Builder;
import lombok.Data;
import ru.egar.spring_work_accounting.employee.EmployeeDto;

import java.time.LocalDate;

@Data
@Builder
public class TotalResponse {

    private long id;
    private int totalWorkedTime;
    private int kpiPercentage;
    private float totalSalary;
    private LocalDate date;
    private EmployeeDto employee;

}
