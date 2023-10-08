package ru.egar.spring_work_accounting.task;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TaskRequest {

    @Size(min = 2, max = 25, message = "Name is incorrect length")
    private String shortName;

    @Size(min = 2, max = 25, message = "Description is incorrect length")
    private String description;

    private LocalDateTime dateTimeStart;

    private LocalDateTime dateTimeEnd;

    @Min(value = 20, message = "Minimal number of points is 20")
    @Max(value = 50, message = "Maximum number of points is 50")
    private int taskPointsNumber;

}
