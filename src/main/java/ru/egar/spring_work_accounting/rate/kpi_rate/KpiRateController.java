package ru.egar.spring_work_accounting.rate.kpi_rate;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.egar.spring_work_accounting.abstraction.exceptions.ExceptionResponse;

@RestController
@RequestMapping("kpi_rate")
@RequiredArgsConstructor
public class KpiRateController {

    private final KpiRateAdapterService kpiRateAdapterService;

    @GetMapping("{id}")
    public ResponseEntity<KpiRateResponse> findKpiRateById(@PathVariable Long id) {
        return ResponseEntity.ok(kpiRateAdapterService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Long> createKpiRate(@RequestBody KpiRateRequest kpiRateRequest) {
        return new ResponseEntity<>(kpiRateAdapterService.save(kpiRateRequest), HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Long> updateKpiRate(@RequestBody KpiRateRequest kpiRateRequest, @PathVariable Long id) {
        var result = kpiRateAdapterService.update(kpiRateRequest, id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteKpiRate(@PathVariable Long id) {
        kpiRateAdapterService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(value = KpiRateNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleKpiRateNotFoundException(KpiRateNotFoundException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
    }

}
