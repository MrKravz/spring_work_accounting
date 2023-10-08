package ru.egar.spring_work_accounting.rate.hour_rate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.egar.spring_work_accounting.abstraction.services.CrudAdapterService;

@Service
@RequiredArgsConstructor
public class HourRateAdapterService implements CrudAdapterService<HourRateRequest, HourRateDto, Long> {

    private final HourRateService hourRateService;
    private final HourRateRequestMapper hourRateRequestMapper;
    private final HourRateDtoMapper hourRateDto;

    @Override
    public HourRateDto findById(Long id) {
        return hourRateDto.map(hourRateService.findById(id));
    }

    @Override
    public Long save(HourRateRequest entity) {
        return hourRateService.save(hourRateRequestMapper.map(entity));
    }

    @Override
    public Long update(HourRateRequest entity, Long id) {
        return hourRateService.update(hourRateRequestMapper.map(entity), id);
    }

    @Override
    public void delete(Long id) {
        hourRateService.delete(id);
    }

}
