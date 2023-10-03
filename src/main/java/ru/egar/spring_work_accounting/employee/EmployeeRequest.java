package ru.egar.spring_work_accounting.employee;

import lombok.Builder;
import lombok.Data;
import ru.egar.spring_work_accounting.rate.hour_rate.PaymentSystem;

import java.time.LocalDate;

@Data
@Builder
public class EmployeeRequest {

    private String name;
    private LocalDate dateOfBirthDay;
    private Position employeePosition;
    private Grade employeeGrade;
    private PaymentSystem paymentSystem;

}
