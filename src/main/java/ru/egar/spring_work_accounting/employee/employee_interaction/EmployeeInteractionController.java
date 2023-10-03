package ru.egar.spring_work_accounting.employee.employee_interaction;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.egar.spring_work_accounting.abstraction.exceptions.ExceptionResponse;
import ru.egar.spring_work_accounting.employee.EmployeeNotFoundException;
import ru.egar.spring_work_accounting.task.TaskNotFoundException;
import ru.egar.spring_work_accounting.task.TaskResponse;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("available_tasks")
@RequiredArgsConstructor
public class EmployeeInteractionController {

    private final EmployeeInteractionService employeeInteractionService;

    @GetMapping
    public ResponseEntity<Set<TaskResponse>> getAvailableTasks() {
        return ResponseEntity.ok(employeeInteractionService.getAvailableTasks());
    }

    @PostMapping("/start")
    public ResponseEntity<UUID> startTask(@RequestBody EmployeeInteractionRequest employeeInteractionRequest) {
        return ResponseEntity.ok(employeeInteractionService.startTask(employeeInteractionRequest));
    }

    @PostMapping("/finish")
    public ResponseEntity<UUID> finishTask(EmployeeInteractionRequest employeeInteractionRequest) {
        return ResponseEntity.ok(employeeInteractionService.finishTask(employeeInteractionRequest));
    }

    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = TaskNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleTaskNotFoundException(TaskNotFoundException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = TaskIsAlreadyStartedException.class)
    public ResponseEntity<ExceptionResponse> handleTaskIsAlreadyStartedException(TaskIsAlreadyStartedException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = TaskIsAlreadyFinishedException.class)
    public ResponseEntity<ExceptionResponse> handleTaskIsAlreadyFinishedException(TaskIsAlreadyFinishedException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
    }

}
