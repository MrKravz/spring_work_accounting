package ru.egar.spring_work_accounting.time_sheet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.services.CrudService;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TimeSheetService implements CrudService<TimeSheet, UUID> {

    private final TimeSheetRepository timeSheetRepository;

    @Override
    public TimeSheet findById(UUID id) {
        return timeSheetRepository.findById(id).orElseThrow(TimeSheetNotFoundException::new);
    }

    @Transactional
    @Override
    public UUID save(TimeSheet entity) {
        return timeSheetRepository.save(entity).getId();
    }

    @Transactional
    @Override
    public UUID update(TimeSheet entity, UUID id) {
        return timeSheetRepository.save(entity).getId();
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        timeSheetRepository.deleteById(id);
    }

}
