package ru.egar.spring_work_accounting.time_sheet;

import lombok.Data;
import ru.egar.spring_work_accounting.employee.EmployeeDto;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class TimeSheetResponse {

    private UUID id;
    private int timeSpan;
    private TimeStatus timeStatus;
    private LocalDate date;
    private EmployeeDto employee;

}
