package ru.egar.spring_work_accounting.total;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenerateTotalRequest {
    private long employeeId;
}
