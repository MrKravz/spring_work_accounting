package ru.egar.spring_work_accounting.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.egar.spring_work_accounting.abstraction.exceptions.ExceptionResponse;

import java.util.UUID;

@RestController
@RequestMapping("employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable UUID id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UUID> createEmployee(@RequestBody Employee employeeRequest) {
        return new ResponseEntity<>(employeeService.save(employeeRequest), HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    public ResponseEntity<UUID> updateEmployee(@RequestBody Employee employeeRequest, @PathVariable UUID id) {
        return ResponseEntity.ok(employeeService.update(employeeRequest, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable UUID id) {
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
    }

}
