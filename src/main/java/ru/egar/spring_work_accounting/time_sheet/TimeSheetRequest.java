package ru.egar.spring_work_accounting.time_sheet;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Data;
import ru.egar.spring_work_accounting.employee.EmployeeDto;

@Data
@Builder
public class TimeSheetRequest {

    @Min(value = 0, message = "Minimal time span is 0")
    @Max(value = 12, message = "Maximum time span is 12")
    private int timeSpan;

    private TimeStatus timeStatus;

    private EmployeeDto employee;

}
