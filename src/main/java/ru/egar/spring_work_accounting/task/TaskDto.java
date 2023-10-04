package ru.egar.spring_work_accounting.task;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TaskDto {

    private long id;
    private String shortName;
    private String description;
    private LocalDateTime dateTimeStart;
    private LocalDateTime dateTimeEnd;
    private int taskPointsNumber;
    private TaskStatus taskStatus;

}
