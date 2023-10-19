package ru.egar.spring_work_accounting.bonus;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BonusRequest {

    @Min(value = 1, message = "Minimal bonus salary is 1")
    private float bonusSalary;

}
