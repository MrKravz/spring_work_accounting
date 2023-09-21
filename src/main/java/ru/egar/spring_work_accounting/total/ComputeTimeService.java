package ru.egar.spring_work_accounting.total;

import ru.egar.spring_work_accounting.employee.EmployeeRepository;
import ru.egar.spring_work_accounting.time_sheet.TimeSheet;
import ru.egar.spring_work_accounting.time_sheet.TimeSheetRepository;
import ru.egar.spring_work_accounting.time_sheet.TimeStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Service computes and returns time that employee spent by time status
 * between start and end dates.
 **/
public class ComputeTimeService {

    private final EmployeeRepository employeeRepository;
    private final TimeSheetRepository timeSheetRepository;
    private int totalTime = 0;

    public ComputeTimeService(EmployeeRepository employeeRepository, TimeSheetRepository timeSheetRepository) {
        this.employeeRepository = employeeRepository;
        this.timeSheetRepository = timeSheetRepository;
    }

    public int computeTime(UUID employeeId, TimeStatus timeStatus, LocalDate dateStart, LocalDate dateEnd) {
        var employee = employeeRepository.findEmployeeById(employeeId);
        if (employee.isEmpty()) {
            throw new RuntimeException();
        }
        List<TimeSheet> timeSheets = timeSheetRepository.findAllByDateAndEmployee(employee.get(), dateStart, dateEnd)
                .stream()
                .filter(x -> x.getTimeStatus().equals(timeStatus))
                .toList();
        for (var timeSheet : timeSheets) {
            totalTime += timeSheet.getTimeSpan();
        }
        return totalTime;
    }

}
