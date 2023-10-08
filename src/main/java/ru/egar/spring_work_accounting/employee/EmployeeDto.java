package ru.egar.spring_work_accounting.employee;

import lombok.Builder;
import lombok.Data;
import ru.egar.spring_work_accounting.rate.hour_rate.HourRateDto;
import ru.egar.spring_work_accounting.rate.hour_rate.PaymentSystem;
import ru.egar.spring_work_accounting.rate.kpi_rate.KpiRateDto;
import ru.egar.spring_work_accounting.task.TaskDto;
import ru.egar.spring_work_accounting.time_sheet.TimeSheetDto;
import ru.egar.spring_work_accounting.total.TotalDto;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class EmployeeDto {

    private long id;
    private String name;
    private LocalDate dateOfBirthDay;
    private Position employeePosition;
    private Grade employeeGrade;
    private PaymentSystem paymentSystem;
    private HourRateDto hourRate;
    private KpiRateDto kpiRate;
    private List<TimeSheetDto> timeSheets;
    private List<TaskDto> tasks;
    private List<TotalDto> totals;

}
