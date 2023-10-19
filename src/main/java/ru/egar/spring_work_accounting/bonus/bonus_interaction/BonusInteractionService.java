package ru.egar.spring_work_accounting.bonus.bonus_interaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.bonus.BonusService;
import ru.egar.spring_work_accounting.total.TotalService;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BonusInteractionService {

    private final TotalService totalService;
    private final BonusService bonusService;

    @Transactional
    public void setBonus(BonusInteractionRequest bonusInteractionRequest) {
        var bonus = bonusService.findById(bonusInteractionRequest.getBonusId());
        var total = totalService.findById(bonusInteractionRequest.getTotalId());
        if (total.getBonus() != null) {
            final String message = "Bonus already had been set";
            throw new BonusAlreadySetException(message);
        }
        total.setBonus(bonus);
        total.setTotalSalary(total.getTotalSalary() + bonus.getBonusSalary());
        totalService.update(total, bonusInteractionRequest.getTotalId());
    }

    @Transactional
    public void deleteBonus(BonusInteractionRequest bonusInteractionRequest) {
        var total = totalService.findById(bonusInteractionRequest.getTotalId());
        if (total.getBonus() == null) {
            final String message = "Bonus not set";
            throw new BonusIsNotSetException(message);
        }
        var bonus = total.getBonus();
        total.setTotalSalary(total.getTotalSalary() - bonus.getBonusSalary());
        total.setBonus(null);
        bonus.setIsDeleted(true);
        totalService.update(total, bonusInteractionRequest.getTotalId());
    }

}
