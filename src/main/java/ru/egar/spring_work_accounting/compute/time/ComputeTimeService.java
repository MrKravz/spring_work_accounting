package ru.egar.spring_work_accounting.compute.time;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.employee.Employee;
import ru.egar.spring_work_accounting.time_sheet.TimeSheet;
import ru.egar.spring_work_accounting.time_sheet.TimeSheetRepository;
import ru.egar.spring_work_accounting.time_sheet.TimeStatus;

import java.time.LocalDate;
import java.util.List;

/**
 * Service computes and returns time that employee spent by time status
 * between start and end dates.
 **/
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ComputeTimeService {

    private final TimeSheetRepository timeSheetRepository;

    public int computeTime(Employee employee, TimeStatus timeStatus, LocalDate dateStart, LocalDate dateEnd) {
        List<TimeSheet> timeSheets = timeSheetRepository.findAllByEmployeeAndDateBetween(employee, dateStart, dateEnd)
                .stream()
                .filter(x -> x.getTimeStatus().equals(timeStatus))
                .toList();
        return timeSheets
                .stream()
                .mapToInt(TimeSheet::getTimeSpan)
                .sum();
    }

}
