package ru.egar.spring_work_accounting.total;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.egar.spring_work_accounting.abstraction.exceptions.ExceptionResponse;
import ru.egar.spring_work_accounting.employee.EmployeeNotFoundException;

import java.util.UUID;

@RestController
@RequestMapping("totals")
@RequiredArgsConstructor
public class TotalController {

    private final TotalService totalService;

    @GetMapping("{id}")
    private ResponseEntity<TotalResponse> findTotalById(@PathVariable UUID id) {
        return ResponseEntity.ok(totalService.findById(id));
    }

    @PostMapping("{employee_id}")
    private ResponseEntity<UUID> createTotal(@PathVariable("employee_id") UUID employeeId) {
        return new ResponseEntity<>(totalService.createTotal(employeeId), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    private HttpStatus deleteTotal(@PathVariable UUID id) {
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
