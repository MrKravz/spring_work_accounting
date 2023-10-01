package ru.egar.spring_work_accounting.rate.hour_rate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.abstraction.services.CrudService;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HourRateService implements CrudService<HourRate, UUID> {

    private final HourRateRepository hourRateRepository;

    @Override
    public HourRate findById(UUID id) {
        return hourRateRepository.findById(id).orElseThrow(HourRateNotFoundException::new);
    }

    @Override
    @Transactional
    public UUID save(HourRate entity) {
        return hourRateRepository.save(entity).getId();
    }

    @Override
    @Transactional
    public UUID update(HourRate entity, UUID id) {
        return hourRateRepository.save(entity).getId();
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        hourRateRepository.deleteById(id);
    }

}
