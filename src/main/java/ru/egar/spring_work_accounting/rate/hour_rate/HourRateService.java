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
        return hourRateRepository.findById(id).orElseThrow(HourRateNotFoundException::new);
    }

    public HourRate findByPositionAndGrade(Position position, Grade grade) {
        return hourRateRepository.findByPositionAndGrade(position, grade).orElseThrow(HourRateNotFoundException::new);
    }

    @Override
    @Transactional
    public Long save(HourRate entity) {
        return hourRateRepository.save(entity).getId();
    }

    @Override
    @Transactional
    public Long update(HourRate entity, Long id) {
        return hourRateRepository.save(entity).getId();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        hourRateRepository.deleteById(id);
    }

}
