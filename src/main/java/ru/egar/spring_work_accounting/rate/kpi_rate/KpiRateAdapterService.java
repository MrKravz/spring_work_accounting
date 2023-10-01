package ru.egar.spring_work_accounting.rate.kpi_rate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.egar.spring_work_accounting.abstraction.services.CrudAdapterService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class KpiRateAdapterService implements CrudAdapterService<KpiRateRequest, KpiRateResponse, UUID> {

    private final KpiRateService kpiRateService;
    private final KpiRateRequestMapper kpiRateRequestMapper;
    private final KpiRateResponseMapper kpiRateResponseMapper;

    @Override
    public KpiRateResponse findById(UUID id) {
        return kpiRateResponseMapper.map(kpiRateService.findById(id));
    }

    @Override
    public UUID save(KpiRateRequest entity) {
        return kpiRateService.save(kpiRateRequestMapper.map(entity));
    }

    @Override
    public UUID update(KpiRateRequest entity, UUID id) {
        return kpiRateService.update(kpiRateRequestMapper.map(entity), id);
    }

    @Override
    public void delete(UUID id) {
        kpiRateService.delete(id);
    }

}
