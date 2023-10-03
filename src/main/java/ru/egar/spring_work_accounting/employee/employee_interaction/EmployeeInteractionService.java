package ru.egar.spring_work_accounting.employee.employee_interaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.employee.EmployeeService;
import ru.egar.spring_work_accounting.task.TaskResponse;
import ru.egar.spring_work_accounting.task.TaskResponseMapper;
import ru.egar.spring_work_accounting.task.TaskService;
import ru.egar.spring_work_accounting.task.TaskStatus;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * This service purpose is to provide way for employees to interact with tasks.
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EmployeeInteractionService {

    private final EmployeeService employeeService;
    private final TaskService taskService;
    private final TaskResponseMapper taskResponseMapper;

    public Set<TaskResponse> getAvailableTasks() {
        var startedTasks = taskService.findAll()
                .stream()
                .filter(x->x.getEmployee() == null)
                .collect(Collectors.toSet());
        return (Set<TaskResponse>) taskResponseMapper.iterableMap(startedTasks);
    }

    public UUID startTask(EmployeeInteractionRequest employeeInteractionRequest) {
        var task = taskService.findById(employeeInteractionRequest.getTaskId());
        if (task.getEmployee() != null) {
            final String exceptionMessage = "This task has already been started";
            throw new TaskIsAlreadyStartedException(exceptionMessage);
        }
        var employee = employeeService.findById(employeeInteractionRequest.getEmployeeId());
        final TaskStatus taskStatusInProcess = TaskStatus.IN_PROCESS;
        task.setEmployee(employee);
        task.setTaskStatus(taskStatusInProcess);
        return taskService.update(task, task.getId());
    }

    public UUID finishTask(EmployeeInteractionRequest employeeInteractionRequest) {
        var task = taskService.findById(employeeInteractionRequest.getTaskId());
        final TaskStatus taskStatusFinished = TaskStatus.FINISHED;
        if (task.getTaskStatus().equals(taskStatusFinished)) {
            final String exceptionMessage = "This task has already been finished";
            throw new TaskIsAlreadyFinishedException(exceptionMessage);
        }
        task.setTaskStatus(taskStatusFinished);
        return taskService.update(task, task.getId());
    }

}
