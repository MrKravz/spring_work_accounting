package ru.egar.spring_work_accounting.compute.time;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.employee.Employee;
import ru.egar.spring_work_accounting.time_sheet.TimeSheet;
import ru.egar.spring_work_accounting.time_sheet.TimeSheetRepository;
import ru.egar.spring_work_accounting.time_sheet.TimeStatus;

import java.time.LocalDate;

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
        var timeSheets = timeSheetRepository.findAllByDateBetween(dateStart, dateEnd)
                .stream()
                .filter(x -> x.getEmployee() == employee)
                .filter(x -> x.getTimeStatus().equals(timeStatus))
                .toList();
        return timeSheets
                .stream()
                .mapToInt(TimeSheet::getTimeSpan)
                .sum();
    }

}
