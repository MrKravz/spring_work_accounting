package ru.egar.spring_work_accounting.task;

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
public class TaskExceptionHandler extends ResponseEntityExceptionHandler implements EntityExceptionHandler<TaskException>,
        EntityStateExceptionHandler<TaskStateException> {

    private final Logger logger = LoggerFactory.getLogger(TaskExceptionHandler.class);

    @Override
    @ExceptionHandler(value = TaskException.class)
    public ResponseEntity<ExceptionResponse> handleEntityRelatedException(TaskException ex) {
        logger.error(ex.getMessage());
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @Override
    @ExceptionHandler(value = TaskStateException.class)
    public ResponseEntity<ExceptionResponse> handleEntityStateRelatedException(TaskStateException ex) {
        logger.error(ex.getMessage());
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

}
