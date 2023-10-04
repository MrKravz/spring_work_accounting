package ru.egar.spring_work_accounting.employee.employee_interaction;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeInteractionRequest {

    private long employeeId;
    private long taskId;

}
