package ru.egar.spring_work_accounting.rate.kpi_rate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.abstraction.services.CrudService;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class KpiRateService implements CrudService<KpiRate, UUID> {

    private final KpiRateRepository kpiRateRepository;

    @Override
    public KpiRate findById(UUID id) {
        return kpiRateRepository.findById(id).orElseThrow(KpiRateNotFoundException::new);
    }

    @Override
    @Transactional
    public UUID save(KpiRate entity) {
        return kpiRateRepository.save(entity).getId();
    }

    @Override
    @Transactional
    public UUID update(KpiRate entity, UUID id) {
        return kpiRateRepository.save(entity).getId();
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        kpiRateRepository.deleteById(id);
    }

}
