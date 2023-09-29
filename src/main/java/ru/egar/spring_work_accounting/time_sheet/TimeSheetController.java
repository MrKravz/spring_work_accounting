package ru.egar.spring_work_accounting.time_sheet;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.egar.spring_work_accounting.exceptions.ExceptionResponse;

import java.util.UUID;

@RestController
@RequestMapping("time_sheets")
@RequiredArgsConstructor
public class TimeSheetController {

    private final TimeSheetService timeSheetService;

    @GetMapping("{id}")
    public ResponseEntity<TimeSheet> findTimeSheetById(@PathVariable UUID id) {
        return ResponseEntity.ok(timeSheetService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UUID> createTimeSheet(@RequestBody TimeSheet timeSheet) {
        return new ResponseEntity<>(timeSheetService.save(timeSheet), HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    public ResponseEntity<UUID> updateTimeSheet(@RequestBody TimeSheet timeSheet, @PathVariable UUID id) {
        var result = timeSheetService.update(timeSheet, id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<UUID> deleteTimeSheet(@PathVariable UUID id) {
        timeSheetService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(value = TimeSheetNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleTaskNotFoundException(TimeSheetNotFoundException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
    }

}
