package ru.egar.spring_work_accounting.time_sheet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.egar.spring_work_accounting.abstraction.services.CrudAdapterService;

@Service
@RequiredArgsConstructor
public class TimeSheetAdapterService implements CrudAdapterService<TimeSheetRequest, TimeSheetResponse, Long> {

    private final TimeSheetService timeSheetService;
    private final TimeSheetResponseMapper timeSheetResponseMapper;
    private final TimeSheetRequestMapper timeSheetRequestMapper;

    @Override
    public TimeSheetResponse findById(Long id) {
        return timeSheetResponseMapper.map(timeSheetService.findById(id));
    }

    @Override
    public Long save(TimeSheetRequest entity) {
        return timeSheetService.save(timeSheetRequestMapper.map(entity));
    }

    @Override
    public Long update(TimeSheetRequest entity, Long id) {
        return timeSheetService.update(timeSheetRequestMapper.map(entity), id);
    }

    @Override
    public void delete(Long id) {
        timeSheetService.delete(id);
    }

}
