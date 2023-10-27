package ru.egar.spring_work_accounting.bonus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.egar.spring_work_accounting.abstraction.exceptions.EntityExceptionHandler;
import ru.egar.spring_work_accounting.abstraction.exceptions.EntityStateExceptionHandler;
import ru.egar.spring_work_accounting.abstraction.exceptions.ExceptionResponse;

import java.time.LocalDateTime;

@RestControllerAdvice
public class BonusExceptionHandler extends ResponseEntityExceptionHandler implements EntityExceptionHandler<BonusException>,
        EntityStateExceptionHandler<BonusStateException> {

    private final Logger logger = LoggerFactory.getLogger(BonusExceptionHandler.class);

    @Override
    @ExceptionHandler(value = BonusException.class)
    public ResponseEntity<ExceptionResponse> handleEntityRelatedException(BonusException ex) {
        logger.error(ex.getMessage());
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(),LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @Override
    @ExceptionHandler(value = BonusStateException.class)
    public ResponseEntity<ExceptionResponse> handleEntityStateRelatedException(BonusStateException ex) {
        logger.error(ex.getMessage());
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(),LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

}
