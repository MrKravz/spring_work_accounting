package ru.egar.spring_work_accounting.employee.employee_interaction;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.egar.spring_work_accounting.task.TaskDto;

import java.util.List;

@RestController
@RequestMapping("/available_tasks")
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
    public ResponseEntity<Long> finishTask(@RequestBody EmployeeInteractionRequest employeeInteractionRequest) {
        return ResponseEntity.ok(employeeInteractionService.finishTask(employeeInteractionRequest));
    }

}
