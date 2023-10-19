package ru.egar.spring_work_accounting.bonus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BonusDto {

    private Long id;
    private Float bonusSalary;

}
