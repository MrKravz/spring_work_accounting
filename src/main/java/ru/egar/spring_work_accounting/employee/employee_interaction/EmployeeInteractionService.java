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
    private final TaskResponseMapper taskResponseMapper;

    public List<TaskResponse> getAvailableTasks() {
        var startedTasks = taskService.findAll()
                .stream()
                .filter(x->x.getEmployee() == null)
                .toList();
        return (List<TaskResponse>) taskResponseMapper.iterableMap(startedTasks);
    }

    public long startTask(EmployeeInteractionRequest employeeInteractionRequest) {
        var task = taskService.findById(employeeInteractionRequest.getTaskId());
        if (task.getEmployee() != null) {
            final String exceptionMessage = "This task has already been started";
            throw new TaskIsAlreadyStartedException(exceptionMessage);
        }
        var employee = employeeService.findById(employeeInteractionRequest.getEmployeeId());
        final TaskStatus taskStatusInProcess = TaskStatus.IN_PROCESS;
        task.setEmployee(employee);
        task.setTaskStatus(taskStatusInProcess);
        task.setDateTimeStart(LocalDateTime.now());
        return taskService.update(task, task.getId());
    }

    public long finishTask(EmployeeInteractionRequest employeeInteractionRequest) {
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
