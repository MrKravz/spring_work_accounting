package ru.egar.spring_work_accounting.time_sheet;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.egar.spring_work_accounting.abstraction.exceptions.ExceptionResponse;

import java.util.UUID;

@RestController
@RequestMapping("time_sheets")
@RequiredArgsConstructor
public class TimeSheetController {

    private final TimeSheetAdapterService timeSheetAdapterService;

    @GetMapping("{id}")
    public ResponseEntity<TimeSheetResponse> findTimeSheetById(@PathVariable UUID id) {
        return ResponseEntity.ok(timeSheetAdapterService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UUID> createTimeSheet(@RequestBody TimeSheetRequest timeSheetRequest) {
        return new ResponseEntity<>(timeSheetAdapterService.save(timeSheetRequest), HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    public ResponseEntity<UUID> updateTimeSheet(@RequestBody TimeSheetRequest timeSheetRequest, @PathVariable UUID id) {
        var result = timeSheetAdapterService.update(timeSheetRequest, id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<UUID> deleteTimeSheet(@PathVariable UUID id) {
        timeSheetAdapterService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(value = TimeSheetNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleTaskNotFoundException(TimeSheetNotFoundException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
    }

}
