package ru.egar.spring_work_accounting.time_sheet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.egar.spring_work_accounting.employee.Employee;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheet, Long> {

    @Query("SELECT t FROM TimeSheet t" +
            " WHERE t.date BETWEEN :dateStart AND :dateEnd")
    List<TimeSheet> findAllByDateBetween(LocalDate dateStart, LocalDate dateEnd);

}
