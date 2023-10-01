package ru.egar.spring_work_accounting.task;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.egar.spring_work_accounting.abstraction.exceptions.ExceptionResponse;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskAdapterService taskAdapterService;

    @GetMapping
    public ResponseEntity<List<TaskResponse>> findTasks() {
        return ResponseEntity.ok(taskAdapterService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<TaskResponse> findTaskById(@PathVariable UUID id) {
        return ResponseEntity.ok(taskAdapterService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UUID> createTask(@RequestBody TaskRequest taskRequest) {
        return new ResponseEntity<>(taskAdapterService.save(taskRequest), HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    public ResponseEntity<UUID> updateTask(@RequestBody TaskRequest taskRequest, @PathVariable UUID id) {
        var result = taskAdapterService.update(taskRequest, id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteTask(@PathVariable UUID id) {
        taskAdapterService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(value = TaskNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleTaskNotFoundException(TaskNotFoundException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
    }

}
