package ru.egar.spring_work_accounting.rate.kpi_rate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.egar.spring_work_accounting.abstraction.services.CrudAdapterService;

@Service
@RequiredArgsConstructor
public class KpiRateAdapterService implements CrudAdapterService<KpiRateRequest, KpiRateDto, Long> {

    private final KpiRateService kpiRateService;
    private final KpiRateRequestMapper kpiRateRequestMapper;
    private final KpiRateDtoMapper kpiRateDtoMapper;

    @Override
    public KpiRateDto findById(Long id) {
        return kpiRateDtoMapper.map(kpiRateService.findById(id));
    }

    @Override
    public Long save(KpiRateRequest entity) {
        var result = kpiRateRequestMapper.map(entity);
        result.setIsDeleted(false);
        return kpiRateService.save(result);
    }

    @Override
    public Long update(KpiRateRequest entity, Long id) {
        var result = kpiRateRequestMapper.map(entity);
        result.setIsDeleted(false);
        return kpiRateService.update(result, id);
    }

    @Override
    public void delete(Long id) {
        kpiRateService.delete(id);
    }

}
