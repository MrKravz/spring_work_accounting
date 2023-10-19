package ru.egar.spring_work_accounting.bonus;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.abstraction.services.CrudService;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BonusService implements CrudService<Bonus, Long> {

    private final BonusRepository bonusRepository;

    @Override
    public Bonus findById(Long id) {
        Bonus bonus = bonusRepository.findById(id).orElseThrow(BonusNotFoundException::new);
        if (bonus.getIsDeleted()) {
            throw new BonusNotFoundException();
        }
        return bonus;
    }

    @Override
    @Transactional
    public Long save(Bonus bonus) {
        return bonusRepository.save(bonus).getId();
    }

    @Override
    @Transactional
    public Long update(Bonus entity, Long id) {
        var bonusToUpdate = findById(id);
        bonusToUpdate.setBonusSalary(entity.getBonusSalary());
        bonusToUpdate.setIsDeleted(entity.getIsDeleted());
        return save(bonusToUpdate);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        var bonus = findById(id);
        bonus.setIsDeleted(true);
        update(bonus, id);
    }

}
