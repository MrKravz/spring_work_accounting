package ru.egar.spring_work_accounting.rate.hour_rate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.egar.spring_work_accounting.abstraction.exceptions.EntityExceptionHandler;
import ru.egar.spring_work_accounting.abstraction.exceptions.ExceptionResponse;

import java.time.LocalDateTime;

@RestControllerAdvice
public class HourRateExceptionHandler extends ResponseEntityExceptionHandler implements EntityExceptionHandler<HourRateException> {

    private final Logger logger = LoggerFactory.getLogger(HourRateExceptionHandler.class);

    @Override
    @ExceptionHandler(value = HourRateException.class)
    public ResponseEntity<ExceptionResponse> handleEntityRelatedException(HourRateException ex) {
        logger.error(ex.getMessage());
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

}
