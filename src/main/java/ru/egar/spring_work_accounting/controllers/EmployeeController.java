package ru.egar.spring_work_accounting.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.egar.spring_work_accounting.ExceptionResponse;
import ru.egar.spring_work_accounting.employee.Employee;
import ru.egar.spring_work_accounting.employee.EmployeeNotFoundException;
import ru.egar.spring_work_accounting.services.EmployeeService;

import java.util.UUID;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController { // TODO refactor

    private final EmployeeService employeeService;

    @GetMapping("{id}")
    private ResponseEntity<Employee> findEmployeeById(@PathVariable UUID id) {
        var result = employeeService.findById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    private ResponseEntity<UUID> createEmployee(@RequestBody Employee employeeRequest) {
        var result = employeeService.create(employeeRequest);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("{id}")
    private ResponseEntity<UUID> updateEmployee(@RequestBody Employee employeeRequest, @PathVariable UUID id) {
        var result = employeeService.update(employeeRequest, id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("{id}")
    private HttpStatus deleteEmployee(@PathVariable UUID id) {
       employeeService.delete(id);
        return HttpStatus.OK;
    }

    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleBrandNotCreatedException(EmployeeNotFoundException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
    }

}
