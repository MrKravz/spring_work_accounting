package ru.egar.spring_work_accounting.total;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("totals")
@RequiredArgsConstructor
public class TotalController {

    private final TotalAdapterService totalAdapterService;

    @GetMapping("{id}")
    private ResponseEntity<TotalDto> findTotalById(@PathVariable Long id) {
        return ResponseEntity.ok(totalAdapterService.findById(id));
    }

    @PostMapping
    private ResponseEntity<Long> createTotal(@RequestBody GenerateTotalRequest generateTotalRequest) {
        return new ResponseEntity<>(totalAdapterService.generateTotal(generateTotalRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    private HttpStatus deleteTotal(@PathVariable Long id) {
        totalAdapterService.delete(id);
        return HttpStatus.OK;
    }

}
