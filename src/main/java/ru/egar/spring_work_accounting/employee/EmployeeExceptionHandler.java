package ru.egar.spring_work_accounting.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.egar.spring_work_accounting.abstraction.exceptions.ExceptionResponse;

import java.time.LocalDateTime;

@RestControllerAdvice
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = EmployeeNotCreatedException.class)
    public ResponseEntity<ExceptionResponse> handleEmployeeNotCreatedException(EmployeeNotCreatedException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = EmployeeNotUpdatedException.class)
    public ResponseEntity<ExceptionResponse> handleEmployeeNotUpdatedException(EmployeeNotUpdatedException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(),LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

}
