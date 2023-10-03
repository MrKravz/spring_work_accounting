package ru.egar.spring_work_accounting.employee.employee_interaction;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class EmployeeInteractionRequest {

    private UUID employeeId;
    private UUID taskId;

}
