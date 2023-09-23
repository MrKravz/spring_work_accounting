package ru.egar.spring_work_accounting.compute.kpi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.employee.Employee;
import ru.egar.spring_work_accounting.task.Task;
import ru.egar.spring_work_accounting.task.TaskStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ComputeKpiService {


    public int computeKpi(Employee employee, LocalDate dateStart, LocalDate dateEnd) {
        final int percentMultiplier = 100;
        final int hours = 0;
        final int minutes = 0;
        var dateTimeStart = LocalDateTime.of(dateStart.getYear(), dateStart.getMonth(),
                dateStart.getDayOfYear() - 1, hours, minutes);
        var dateTimeEnd = LocalDateTime.of(dateEnd.getYear(), dateEnd.getMonth(),
                dateEnd.getDayOfYear() + 1, hours, minutes);
        Set<Task> finishedTasks = getFinishedTasks(employee, dateTimeStart, dateTimeEnd);
        int totalKpiPoints = getTotalKpiPoints(finishedTasks);
        return totalKpiPoints / employee.getKpiRate().getAgreedTasksPointQuantity() * percentMultiplier;
    }

    private Set<Task> getFinishedTasks(Employee employee, LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd) {
        return employee.getTasks()
                .stream()
                .filter(x -> x.getTaskStatus().equals(TaskStatus.Finished))
                .filter(x -> x.getDateTimeStart().isAfter(dateTimeStart)
                        && x.getDateTimeEnd().isBefore(dateTimeEnd))
                .collect(Collectors.toSet());
    }

    private int getTotalKpiPoints(Set<Task> finishedTasks) {
        int totalKpiPoints = 0;
        for (var finishedTask : finishedTasks) {
            totalKpiPoints += finishedTask.getTaskPointsNumber();
        }
        return totalKpiPoints;
    }

}
