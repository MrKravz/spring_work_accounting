package ru.egar.spring_work_accounting.total;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TotalDto {

    private long id;
    private int totalWorkedTime;
    private int kpiPercentage;
    private float totalSalary;
    private LocalDate date;

}
