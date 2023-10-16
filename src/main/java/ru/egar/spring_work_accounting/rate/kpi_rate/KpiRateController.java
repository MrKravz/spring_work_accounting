package ru.egar.spring_work_accounting.rate.kpi_rate;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("kpi_rate")
@RequiredArgsConstructor
public class KpiRateController {

    private final KpiRateAdapterService kpiRateAdapterService;

    @GetMapping("{id}")
    public ResponseEntity<KpiRateDto> findKpiRateById(@PathVariable Long id) {
        return ResponseEntity.ok(kpiRateAdapterService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Long> createKpiRate(@RequestBody @Valid KpiRateRequest kpiRateRequest,
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
            throw new KpiRateNotCreatedException(errorMessage.toString());
        }
        return new ResponseEntity<>(kpiRateAdapterService.save(kpiRateRequest), HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Long> updateKpiRate(@RequestBody @Valid KpiRateRequest kpiRateRequest,
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
            throw new KpiRateNotUpdatedException(errorMessage.toString());
        }
        var result = kpiRateAdapterService.update(kpiRateRequest, id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteKpiRate(@PathVariable Long id) {
        kpiRateAdapterService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
