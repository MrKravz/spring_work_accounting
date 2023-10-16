package ru.egar.spring_work_accounting.time_sheet;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("time_sheets")
@RequiredArgsConstructor
public class TimeSheetController {

    private final TimeSheetAdapterService timeSheetAdapterService;

    @GetMapping("{id}")
    public ResponseEntity<TimeSheetDto> findTimeSheetById(@PathVariable Long id) {
        return ResponseEntity.ok(timeSheetAdapterService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Long> createTimeSheet(@RequestBody @Valid TimeSheetRequest timeSheetRequest,
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
            throw new TimeSheetNotCreatedException(errorMessage.toString());
        }
        return new ResponseEntity<>(timeSheetAdapterService.save(timeSheetRequest), HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Long> updateTimeSheet(@RequestBody @Valid TimeSheetRequest timeSheetRequest,
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
            throw new TimeSheetNotUpdatedException(errorMessage.toString());
        }
        var result = timeSheetAdapterService.update(timeSheetRequest, id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteTimeSheet(@PathVariable Long id) {
        timeSheetAdapterService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
