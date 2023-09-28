package ru.egar.spring_work_accounting.task;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class TaskDto {
    private UUID id;
    private String shortName;
    private String description;
    private LocalDateTime dateTimeStart;
    private LocalDateTime dateTimeEnd;
    private int taskPointsNumber;
    private TaskStatus taskStatus;
}
