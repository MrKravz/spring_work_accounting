package ru.egar.spring_work_accounting.employee;

import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import ru.egar.spring_work_accounting.rate.hour_rate.PaymentSystem;

import java.time.LocalDate;

@Data
@Builder
public class EmployeeRequest {

    @Size(min = 2, max = 25, message = "Name is incorrect length")
    private String name;

    private LocalDate dateOfBirthDay;

    private Position employeePosition;

    private Grade employeeGrade;

    private PaymentSystem paymentSystem;

}
