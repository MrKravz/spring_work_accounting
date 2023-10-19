package ru.egar.spring_work_accounting.bonus;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.egar.spring_work_accounting.abstraction.exceptions.ExceptionResponse;
import ru.egar.spring_work_accounting.bonus.bonus_interaction.BonusAlreadySetException;
import ru.egar.spring_work_accounting.bonus.bonus_interaction.BonusIsNotSetException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class BonusExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = BonusNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleBonusNotFoundException(BonusNotFoundException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = BonusNotCreatedException.class)
    public ResponseEntity<ExceptionResponse> handleBonusNotCreatedException(BonusNotCreatedException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = BonusNotUpdatedException.class)
    public ResponseEntity<ExceptionResponse> handleBonusNotUpdatedException(BonusNotUpdatedException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(),LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = BonusIsNotSetException.class)
    public ResponseEntity<ExceptionResponse> handleBonusIsNotSetException(BonusIsNotSetException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(),LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = BonusAlreadySetException.class)
    public ResponseEntity<ExceptionResponse> handleBonusAlreadySetException(BonusAlreadySetException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(),LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

}
