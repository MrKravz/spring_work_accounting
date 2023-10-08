package ru.egar.spring_work_accounting.employee;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.egar.spring_work_accounting.abstraction.exceptions.ExceptionResponse;

import java.util.List;

@RestController
@RequestMapping("employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeAdapterService employeeAdapterService;

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> findEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeAdapterService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Long> createEmployee(@RequestBody @Valid EmployeeRequest employeeRequest,
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
            throw new EmployeeNotCreatedException(errorMessage.toString());
        }
        return new ResponseEntity<>(employeeAdapterService.save(employeeRequest), HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Long> updateEmployee(@RequestBody @Valid EmployeeRequest employeeRequest,
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
            throw new EmployeeNotUpdatedException(errorMessage.toString());
        }
        return ResponseEntity.ok(employeeAdapterService.update(employeeRequest, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id) {
        employeeAdapterService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = EmployeeNotCreatedException.class)
    public ResponseEntity<ExceptionResponse> handleEmployeeNotCreatedException(EmployeeNotCreatedException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = EmployeeNotUpdatedException.class)
    public ResponseEntity<ExceptionResponse> handleEmployeeNotUpdatedException(EmployeeNotUpdatedException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
    }

}
