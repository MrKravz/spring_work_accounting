package ru.egar.spring_work_accounting.total;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.egar.spring_work_accounting.abstraction.exceptions.ExceptionResponse;
import ru.egar.spring_work_accounting.employee.EmployeeNotFoundException;

@RestController
@RequestMapping("totals")
@RequiredArgsConstructor
public class TotalController {

    private final TotalService totalService;

    @GetMapping("{id}")
    private ResponseEntity<TotalDto> findTotalById(@PathVariable Long id) {
        return ResponseEntity.ok(totalService.findById(id));
    }

    @PostMapping
    private ResponseEntity<Long> createTotal(@RequestBody TotalRequest totalRequest) {
        return new ResponseEntity<>(totalService.createTotal(totalRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    private HttpStatus deleteTotal(@PathVariable Long id) {
        totalService.delete(id);
        return HttpStatus.OK;
    }

    @ExceptionHandler(value = TotalNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleTotalNotFoundException(TotalNotFoundException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
    }

}
