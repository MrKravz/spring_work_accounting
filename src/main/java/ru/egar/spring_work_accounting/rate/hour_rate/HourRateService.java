package ru.egar.spring_work_accounting.rate.hour_rate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.abstraction.services.CrudService;
import ru.egar.spring_work_accounting.employee.Grade;
import ru.egar.spring_work_accounting.employee.Position;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HourRateService implements CrudService<HourRate, Long> {

    private final HourRateRepository hourRateRepository;

    @Override
    public HourRate findById(Long id) {
        var hourRate = hourRateRepository.findById(id).orElseThrow(HourRateNotFoundException::new);
        if (hourRate.getIsDeleted()) {
            throw new HourRateNotFoundException();
        }
        return hourRate;
    }

    public HourRate findByPositionAndGrade(Position position, Grade grade) {
        var hourRate = hourRateRepository.findByPositionAndGrade(position, grade).orElseThrow(HourRateNotFoundException::new);
        if (hourRate.getIsDeleted()) {
            throw new HourRateNotFoundException();
        }
        return hourRate;
    }

    @Override
    @Transactional
    public Long save(HourRate entity) {
        return hourRateRepository.save(entity).getId();
    }

    @Override
    @Transactional
    public Long update(HourRate entity, Long id) {
        var hourRateToUpdate = findById(id);
        hourRateToUpdate.setBusinessTripRate(entity.getBusinessTripRate());
        hourRateToUpdate.setAbsenceRate(entity.getAbsenceRate());
        hourRateToUpdate.setTurnoutRate(entity.getTurnoutRate());
        hourRateToUpdate.setVacationRate(entity.getVacationRate());
        hourRateToUpdate.setOverTimeRate(entity.getOverTimeRate());
        hourRateToUpdate.setSickDaysRate(entity.getSickDaysRate());
        hourRateToUpdate.setGrade(entity.getGrade());
        hourRateToUpdate.setPosition(entity.getPosition());
        hourRateToUpdate.setIsDeleted(entity.getIsDeleted());
        return save(hourRateToUpdate);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        var hourRateToDelete = findById(id);
        hourRateToDelete.setIsDeleted(true);
        save(hourRateToDelete);
    }

}
