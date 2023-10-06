package ru.egar.spring_work_accounting.compute.kpi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.employee.Employee;
import ru.egar.spring_work_accounting.task.Task;
import ru.egar.spring_work_accounting.task.TaskStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * This service purpose is to count kpi value of employee.
 * It counts it in a percentage value that depends on getAgreedTasksPointQuantity amount
 * compared to totalPoints.
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ComputeKpiService {


    public int computeKpi(Employee employee, LocalDate dateStart, LocalDate dateEnd) {
        final float percentMultiplier = 100;
        var dateTimeStart = LocalDateTime.of(dateStart, LocalTime.NOON);
        var dateTimeEnd = LocalDateTime.of(dateEnd, LocalTime.NOON);
        List<Task> finishedTasks = getFinishedTasks(employee, dateTimeStart, dateTimeEnd);
        float totalPoints = getTotalPoints(finishedTasks);
        return (int) (totalPoints / employee.getKpiRate().getAgreedTasksPointQuantity() * percentMultiplier);
    }

    private List<Task> getFinishedTasks(Employee employee, LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd) {
        return employee.getTasks()
                .stream()
                .filter(x -> x.getTaskStatus().equals(TaskStatus.FINISHED))
                .filter(x -> (x.getDateTimeStart().isAfter(dateTimeStart) || x.getDateTimeStart().isEqual(dateTimeStart))
                        && (x.getDateTimeEnd().isBefore(dateTimeEnd) || x.getDateTimeEnd().isEqual(dateTimeEnd)))
                .toList();
    }


    private int getTotalPoints(List<Task> finishedTasks) {
        return finishedTasks.stream().mapToInt(Task::getTaskPointsNumber).sum();
    }

}
