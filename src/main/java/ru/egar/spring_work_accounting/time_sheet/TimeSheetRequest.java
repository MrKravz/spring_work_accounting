package ru.egar.spring_work_accounting.time_sheet;

import lombok.Data;
import ru.egar.spring_work_accounting.employee.EmployeeDto;

import java.time.LocalDate;

@Data
public class TimeSheetRequest {

    private int timeSpan;
    private TimeStatus timeStatus;
    private LocalDate date;
    private EmployeeDto employee;

}