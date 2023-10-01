package ru.egar.spring_work_accounting.rate.hour_rate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.egar.spring_work_accounting.abstraction.services.CrudAdapterService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HourRateAdapterService implements CrudAdapterService<HourRateRequest, HourRateResponse, UUID> {

    private final HourRateService hourRateService;
    private final HourRateRequestMapper hourRateRequestMapper;
    private final HourRateResponseMapper hourRateResponseMapper;

    @Override
    public HourRateResponse findById(UUID id) {
        return hourRateResponseMapper.map(hourRateService.findById(id));
    }

    @Override
    public UUID save(HourRateRequest entity) {
        return hourRateService.save(hourRateRequestMapper.map(entity));
    }

    @Override
    public UUID update(HourRateRequest entity, UUID id) {
        return hourRateService.update(hourRateRequestMapper.map(entity), id);
    }

    @Override
    public void delete(UUID id) {
        hourRateService.delete(id);
    }

}
