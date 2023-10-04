package ru.egar.spring_work_accounting.rate.kpi_rate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.egar.spring_work_accounting.abstraction.services.CrudAdapterService;

@Service
@RequiredArgsConstructor
public class KpiRateAdapterService implements CrudAdapterService<KpiRateRequest, KpiRateResponse, Long> {

    private final KpiRateService kpiRateService;
    private final KpiRateRequestMapper kpiRateRequestMapper;
    private final KpiRateResponseMapper kpiRateResponseMapper;

    @Override
    public KpiRateResponse findById(Long id) {
        return kpiRateResponseMapper.map(kpiRateService.findById(id));
    }

    @Override
    public Long save(KpiRateRequest entity) {
        return kpiRateService.save(kpiRateRequestMapper.map(entity));
    }

    @Override
    public Long update(KpiRateRequest entity, Long id) {
        return kpiRateService.update(kpiRateRequestMapper.map(entity), id);
    }

    @Override
    public void delete(Long id) {
        kpiRateService.delete(id);
    }

}
