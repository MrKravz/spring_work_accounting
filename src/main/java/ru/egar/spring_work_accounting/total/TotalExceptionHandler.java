package ru.egar.spring_work_accounting.total;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.egar.spring_work_accounting.abstraction.exceptions.ExceptionResponse;

import java.time.LocalDateTime;

@ControllerAdvice
public class TotalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = TotalNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleTotalNotFoundException(TotalNotFoundException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

}
