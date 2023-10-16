package ru.egar.spring_work_accounting.rate.kpi_rate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.egar.spring_work_accounting.abstraction.exceptions.ExceptionResponse;

import java.time.LocalDateTime;

@ControllerAdvice
public class KpiRateExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = KpiRateNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleKpiRateNotFoundException(KpiRateNotFoundException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = KpiRateNotCreatedException.class)
    public ResponseEntity<ExceptionResponse> handleKpiRateNotCreatedException(KpiRateNotCreatedException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = KpiRateNotUpdatedException.class)
    public ResponseEntity<ExceptionResponse> handleKpiRateNotUpdatedException(KpiRateNotUpdatedException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

}
