package ru.egar.spring_work_accounting.time_sheet;

import ru.egar.spring_work_accounting.employee.Employee;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

public class TimeSheetRepository {

    public Set<TimeStatus> findDistinctTimeStatuses() {
        return Collections.emptySet();
    }

    public Set<TimeSheet> findAllByDateAndEmployee(Employee employee, LocalDate dateStart, LocalDate dateEnd) {
        return Collections.emptySet();
    }

}
