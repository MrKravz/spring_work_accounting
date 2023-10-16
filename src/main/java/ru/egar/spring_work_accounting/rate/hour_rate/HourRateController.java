package ru.egar.spring_work_accounting.rate.hour_rate;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hour_rate")
@RequiredArgsConstructor
public class HourRateController {

    private final HourRateAdapterService hourRateAdapterService;

    @GetMapping("{id}")
    public ResponseEntity<HourRateDto> findHourRateById(@PathVariable Long id) {
        return ResponseEntity.ok(hourRateAdapterService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Long> createHourRate(@RequestBody @Valid HourRateRequest hourRateRequest,
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
            throw new HourRateNotCreatedException(errorMessage.toString());
        }
        return new ResponseEntity<>(hourRateAdapterService.save(hourRateRequest), HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Long> updateHourRate(@RequestBody @Valid HourRateRequest hourRateRequest,
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
            throw new HourRateNotUpdatedException(errorMessage.toString());
        }
        var result = hourRateAdapterService.update(hourRateRequest, id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteHourRate(@PathVariable Long id) {
        hourRateAdapterService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
