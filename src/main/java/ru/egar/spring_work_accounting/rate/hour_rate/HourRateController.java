package ru.egar.spring_work_accounting.rate.hour_rate;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.egar.spring_work_accounting.abstraction.exceptions.ExceptionResponse;

@RestController
@RequestMapping("hour_rate")
@RequiredArgsConstructor
public class HourRateController {

    private final HourRateAdapterService hourRateAdapterService;

    @GetMapping("{id}")
    public ResponseEntity<HourRateResponse> findHourRateById(@PathVariable Long id) {
        return ResponseEntity.ok(hourRateAdapterService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Long> createHourRate(@RequestBody HourRateRequest hourRateRequest) {
        return new ResponseEntity<>(hourRateAdapterService.save(hourRateRequest), HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Long> updateHourRate(@RequestBody HourRateRequest hourRateRequest, @PathVariable Long id) {
        var result = hourRateAdapterService.update(hourRateRequest, id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteHourRate(@PathVariable Long id) {
        hourRateAdapterService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(value = HourRateNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleHourRateNotFoundException(HourRateNotFoundException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
    }

}
