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
        return kpiRateRepository.findById(id).orElseThrow(KpiRateNotFoundException::new);
    }

    public KpiRate findByPositionAndGrade(Position position, Grade grade) {
        return kpiRateRepository.findByPositionAndGrade(position, grade).orElseThrow(KpiRateNotFoundException::new);
    }

    @Override
    @Transactional
    public Long save(KpiRate entity) {
        return kpiRateRepository.save(entity).getId();
    }

    @Override
    @Transactional
    public Long update(KpiRate entity, Long id) {
        return kpiRateRepository.save(entity).getId();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        kpiRateRepository.deleteById(id);
    }

}
