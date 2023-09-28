package ru.egar.spring_work_accounting.time_sheet;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class TimeSheetDto {
    private UUID id;
    private int timeSpan;
    private TimeStatus timeStatus;
    private LocalDate date;
}
