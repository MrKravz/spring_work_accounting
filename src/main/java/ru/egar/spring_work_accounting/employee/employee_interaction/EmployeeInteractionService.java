package ru.egar.spring_work_accounting.employee.employee_interaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.employee.EmployeeService;
import ru.egar.spring_work_accounting.task.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * This service purpose is to provide way for employees to interact with tasks.
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EmployeeInteractionService {

    private final EmployeeService employeeService;
    private final TaskService taskService;
    private final TaskDtoMapper taskDtoMapper;
    private final TaskStatus taskNotStarted = TaskStatus.NOT_STARTED;
    private final TaskStatus taskStatusInProcess = TaskStatus.IN_PROCESS;
    private final TaskStatus taskStatusFinished = TaskStatus.FINISHED;

    public List<TaskDto> getAvailableTasks() {
        var startedTasks = taskService.findAll()
                .stream()
                .filter(x->x.getTaskStatus().equals(taskNotStarted))
                .toList();
        return (List<TaskDto>) taskDtoMapper.iterableMap(startedTasks);
    }

    @Transactional
    public long startTask(EmployeeInteractionRequest employeeInteractionRequest) {
        var task = taskService.findById(employeeInteractionRequest.getTaskId());
        if (!task.getTaskStatus().equals(taskNotStarted)) {
            final String exceptionMessage = "This task has already been started";
            throw new TaskIsAlreadyStartedException(exceptionMessage);
        }
        var employee = employeeService.findById(employeeInteractionRequest.getEmployeeId());
        task.setEmployee(employee);
        task.setTaskStatus(taskStatusInProcess);
        task.setDateTimeStart(LocalDateTime.now());
        return taskService.update(task, task.getId());
    }

    @Transactional
    public long finishTask(EmployeeInteractionRequest employeeInteractionRequest) {
        var task = taskService.findById(employeeInteractionRequest.getTaskId());
        if (task.getTaskStatus().equals(taskStatusFinished)) {
            final String exceptionMessage = "This task has already been finished";
            throw new TaskIsAlreadyFinishedException(exceptionMessage);
        }
        task.setTaskStatus(taskStatusFinished);
        task.setDateTimeEnd(LocalDateTime.now());
        return taskService.update(task, task.getId());
    }

}
