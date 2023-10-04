package ru.egar.spring_work_accounting.time_sheet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.egar.spring_work_accounting.employee.Employee;

import java.time.LocalDate;
import java.util.Set;

@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheet, Long> {

    @Query("SELECT t.timeStatus FROM TimeSheet t" +
            " WHERE NOT EXISTS (SELECT 1 FROM TimeSheet t1\n" +
            "                   WHERE t.timeStatus=t1.timeStatus)")
    Set<TimeStatus> findDistinctByTimeStatus();

    Set<TimeSheet> findAllByEmployeeAndDateBetween(Employee employee, LocalDate dateStart, LocalDate dateEnd);

}
