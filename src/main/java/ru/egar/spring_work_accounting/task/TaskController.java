package ru.egar.spring_work_accounting.task;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskAdapterService taskAdapterService;

    @GetMapping
    public ResponseEntity<List<TaskDto>> findTasks() {
        return ResponseEntity.ok(taskAdapterService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<TaskDto> findTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskAdapterService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Long> createTask(@RequestBody @Valid TaskRequest taskRequest,
                                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (var error : errors) {
                errorMessage.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";");
            }
            throw new TaskNotCreatedException(errorMessage.toString());
        }
        return new ResponseEntity<>(taskAdapterService.save(taskRequest), HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Long> updateTask(@RequestBody @Valid TaskRequest taskRequest,
                                           @PathVariable Long id,
                                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (var error : errors) {
                errorMessage.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";");
            }
            throw new TaskNotUpdatedException(errorMessage.toString());
        }
        var result = taskAdapterService.update(taskRequest, id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteTask(@PathVariable Long id) {
        taskAdapterService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
