package ru.egar.spring_work_accounting.bonus.bonus_interaction;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BonusInteractionRequest {

    private long bonusId;
    private long totalId;

}
