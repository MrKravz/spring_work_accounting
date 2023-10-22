package ru.egar.spring_work_accounting.time_sheet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.abstraction.services.CrudService;

import java.time.LocalDate;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TimeSheetService implements CrudService<TimeSheet, Long> {

    private final TimeSheetRepository timeSheetRepository;

    @Override
    public TimeSheet findById(Long id) {
        return timeSheetRepository.findById(id).orElseThrow(TimeSheetNotFoundException::new);
    }

    @Transactional
    @Override
    public Long save(TimeSheet entity) {
        entity.setDate(LocalDate.now());
        var timeSheet = timeSheetRepository.save(entity);
        return timeSheet.getId();
    }

    @Transactional
    @Override
    public Long update(TimeSheet entity, Long id) {
        var timeSheetToUpdate = findById(id);
        timeSheetToUpdate.setTimeSpan(entity.getTimeSpan());
        timeSheetToUpdate.setTimeStatus(entity.getTimeStatus());
        timeSheetToUpdate.setDate(entity.getDate());
        return save(timeSheetToUpdate);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        timeSheetRepository.deleteById(id);
    }

}
