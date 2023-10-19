package ru.egar.spring_work_accounting.bonus;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.abstraction.services.CrudAdapterService;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BonusAdapterService implements CrudAdapterService<BonusRequest, BonusDto, Long> {

    private final BonusService bonusService;
    private final BonusRequestMapper bonusRequestMapper;
    private final BonusDtoMapper bonusDtoMapper;

    @Override
    public BonusDto findById(Long id) {
        return bonusDtoMapper.map(bonusService.findById(id));
    }

    @Override
    @Transactional
    public Long save(BonusRequest entity) {
        var result = bonusRequestMapper.map(entity);
        result.setIsDeleted(false);
        return bonusService.save(result);
    }

    @Override
    @Transactional
    public Long update(BonusRequest entity, Long id) {
        return bonusService.update(bonusRequestMapper.map(entity), id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        var bonus = bonusService.findById(id);
        bonus.setIsDeleted(true);
        bonusService.update(bonus, id);
    }

}
