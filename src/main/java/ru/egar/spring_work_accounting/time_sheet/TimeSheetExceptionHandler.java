package ru.egar.spring_work_accounting.time_sheet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.egar.spring_work_accounting.abstraction.exceptions.ExceptionResponse;

import java.time.LocalDateTime;

@RestControllerAdvice
public class TimeSheetExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(TimeSheetExceptionHandler.class);

    @ExceptionHandler(value = TimeSheetNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleTimeSheetNotFoundException(TimeSheetNotFoundException ex) {
        logger.error(ex.getMessage());
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = TimeSheetNotCreatedException.class)
    public ResponseEntity<ExceptionResponse> handleTimeSheetNotCreatedException(TimeSheetNotCreatedException ex) {
        logger.error(ex.getMessage());
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = TimeSheetNotUpdatedException.class)
    public ResponseEntity<ExceptionResponse> handleTimeSheetNotUpdatedException(TimeSheetNotUpdatedException ex) {
        logger.error(ex.getMessage());
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

}
