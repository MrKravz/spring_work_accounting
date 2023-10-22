package ru.egar.spring_work_accounting.rate.kpi_rate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.abstraction.services.CrudService;
import ru.egar.spring_work_accounting.employee.Grade;
import ru.egar.spring_work_accounting.employee.Position;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class KpiRateService implements CrudService<KpiRate, Long> {

    private final KpiRateRepository kpiRateRepository;

    @Override
    public KpiRate findById(Long id) {
        var kpiRate = kpiRateRepository.findById(id).orElseThrow(KpiRateNotFoundException::new);
        if (kpiRate.getIsDeleted()) {
            throw new KpiRateNotFoundException();
        }
        return kpiRate;
    }

    public KpiRate findByPositionAndGrade(Position position, Grade grade) {
        var kpiRate = kpiRateRepository.findByPositionAndGrade(position, grade).orElseThrow(KpiRateNotFoundException::new);
        if (kpiRate.getIsDeleted()) {
            throw new KpiRateNotFoundException();
        }
        return kpiRate;
    }

    @Override
    @Transactional
    public Long save(KpiRate entity) {
        return kpiRateRepository.save(entity).getId();
    }

    @Override
    @Transactional
    public Long update(KpiRate entity, Long id) {
        var kpiRateToUpdate = findById(id);
        kpiRateToUpdate.setAgreedSalary(entity.getAgreedSalary());
        kpiRateToUpdate.setAgreedTasksPointQuantity(entity.getAgreedTasksPointQuantity());
        kpiRateToUpdate.setGrade(entity.getGrade());
        kpiRateToUpdate.setPosition(entity.getPosition());
        kpiRateToUpdate.setIsDeleted(entity.getIsDeleted());
        return save(kpiRateToUpdate);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        var kpiRateToDelete = findById(id);
        kpiRateToDelete.setIsDeleted(true);
        save(kpiRateToDelete);
    }

}
