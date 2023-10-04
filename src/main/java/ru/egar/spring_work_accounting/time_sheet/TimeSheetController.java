package ru.egar.spring_work_accounting.time_sheet;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.egar.spring_work_accounting.abstraction.exceptions.ExceptionResponse;

@RestController
@RequestMapping("time_sheets")
@RequiredArgsConstructor
public class TimeSheetController {

    private final TimeSheetAdapterService timeSheetAdapterService;

    @GetMapping("{id}")
    public ResponseEntity<TimeSheetResponse> findTimeSheetById(@PathVariable Long id) {
        return ResponseEntity.ok(timeSheetAdapterService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Long> createTimeSheet(@RequestBody TimeSheetRequest timeSheetRequest) {
        return new ResponseEntity<>(timeSheetAdapterService.save(timeSheetRequest), HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Long> updateTimeSheet(@RequestBody TimeSheetRequest timeSheetRequest, @PathVariable Long id) {
        var result = timeSheetAdapterService.update(timeSheetRequest, id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteTimeSheet(@PathVariable Long id) {
        timeSheetAdapterService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(value = TimeSheetNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleTaskNotFoundException(TimeSheetNotFoundException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
    }

}
