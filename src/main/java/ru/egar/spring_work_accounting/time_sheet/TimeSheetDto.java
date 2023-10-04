package ru.egar.spring_work_accounting.time_sheet;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class TimeSheetDto {

    private long id;
    private int timeSpan;
    private TimeStatus timeStatus;
    private LocalDate date;

}
