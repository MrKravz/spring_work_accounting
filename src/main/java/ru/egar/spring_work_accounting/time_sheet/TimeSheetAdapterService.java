package ru.egar.spring_work_accounting.time_sheet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.egar.spring_work_accounting.abstraction.services.CrudAdapterService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TimeSheetAdapterService implements CrudAdapterService<TimeSheetRequest, TimeSheetResponse, UUID> {

    private final TimeSheetService timeSheetService;
    private final TimeSheetResponseMapper timeSheetResponseMapper;
    private final TimeSheetRequestMapper timeSheetRequestMapper;

    @Override
    public TimeSheetResponse findById(UUID id) {
        return timeSheetResponseMapper.map(timeSheetService.findById(id));
    }

    @Override
    public UUID save(TimeSheetRequest entity) {
        return timeSheetService.save(timeSheetRequestMapper.map(entity));
    }

    @Override
    public UUID update(TimeSheetRequest entity, UUID id) {
        return timeSheetService.update(timeSheetRequestMapper.map(entity), id);
    }

    @Override
    public void delete(UUID id) {
        timeSheetService.delete(id);
    }

}
