package ru.egar.spring_work_accounting.employee.employee_interaction;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.egar.spring_work_accounting.abstraction.exceptions.ExceptionResponse;
import ru.egar.spring_work_accounting.employee.EmployeeNotFoundException;
import ru.egar.spring_work_accounting.task.TaskDto;
import ru.egar.spring_work_accounting.task.TaskNotFoundException;

import java.util.List;

@RestController
@RequestMapping("available_tasks")
@RequiredArgsConstructor
public class EmployeeInteractionController {

    private final EmployeeInteractionService employeeInteractionService;

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAvailableTasks() {
        return ResponseEntity.ok(employeeInteractionService.getAvailableTasks());
    }

    @PatchMapping("/start")
    public ResponseEntity<Long> startTask(@RequestBody EmployeeInteractionRequest employeeInteractionRequest) {
        return ResponseEntity.ok(employeeInteractionService.startTask(employeeInteractionRequest));
    }

    @PatchMapping("/finish")
    public ResponseEntity<Long> finishTask(EmployeeInteractionRequest employeeInteractionRequest) {
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
