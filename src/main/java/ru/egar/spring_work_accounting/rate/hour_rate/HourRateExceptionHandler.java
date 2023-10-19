package ru.egar.spring_work_accounting.rate.hour_rate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.egar.spring_work_accounting.abstraction.exceptions.ExceptionResponse;

import java.time.LocalDateTime;

@RestControllerAdvice
public class HourRateExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = HourRateNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleHourRateNotFoundException(HourRateNotFoundException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = HourRateNotCreatedException.class)
    public ResponseEntity<ExceptionResponse> handleHourRateNotCreatedException(HourRateNotCreatedException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = HourRateNotUpdatedException.class)
    public ResponseEntity<ExceptionResponse> handleHourRateNotUpdatedException(HourRateNotUpdatedException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

}
