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
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ComputeKpiService {


    public int computeKpi(Employee employee, LocalDate dateStart, LocalDate dateEnd) {
        final float percentMultiplier = 100;
        var dateTimeStart = LocalDateTime.of(dateStart, LocalTime.NOON);
        var dateTimeEnd = LocalDateTime.of(dateEnd, LocalTime.NOON);
        Set<Task> finishedTasks = getFinishedTasks(employee, dateTimeStart, dateTimeEnd);
        float totalKpiPoints = getTotalKpiPoints(finishedTasks);
        return (int) (totalKpiPoints / employee.getKpiRate().getAgreedTasksPointQuantity() * percentMultiplier);
    }

    private Set<Task> getFinishedTasks(Employee employee, LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd) {
        return employee.getTasks()
                .stream()
                .filter(x -> x.getTaskStatus().equals(TaskStatus.Finished))
                .filter(x -> (x.getDateTimeStart().isAfter(dateTimeStart) || x.getDateTimeStart().isEqual(dateTimeStart))
                        && (x.getDateTimeEnd().isBefore(dateTimeEnd) || x.getDateTimeEnd().isEqual(dateTimeEnd)))
                .collect(Collectors.toSet());
    }


    private int getTotalKpiPoints(Set<Task> finishedTasks) {
        return finishedTasks.stream().mapToInt(Task::getTaskPointsNumber).sum();
    }

}
