package ru.egar.spring_work_accounting.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.egar.spring_work_accounting.abstraction.exceptions.ExceptionResponse;
import ru.egar.spring_work_accounting.employee.employee_interaction.TaskIsAlreadyFinishedException;
import ru.egar.spring_work_accounting.employee.employee_interaction.TaskIsAlreadyStartedException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class TaskExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(TaskExceptionHandler.class);

    @ExceptionHandler(value = TaskNotCreatedException.class)
    public ResponseEntity<ExceptionResponse> handleTaskNotCreatedException(TaskNotCreatedException ex) {
        logger.error(ex.getMessage());
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = TaskNotUpdatedException.class)
    public ResponseEntity<ExceptionResponse> handleTaskNotUpdatedException(TaskNotUpdatedException ex) {
        logger.error(ex.getMessage());
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = TaskNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleTaskNotFoundException(TaskNotFoundException ex) {
        logger.error(ex.getMessage());
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = TaskIsAlreadyStartedException.class)
    public ResponseEntity<ExceptionResponse> handleTaskIsAlreadyStartedException(TaskIsAlreadyStartedException ex) {
        logger.error(ex.getMessage());
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = TaskIsAlreadyFinishedException.class)
    public ResponseEntity<ExceptionResponse> handleTaskIsAlreadyFinishedException(TaskIsAlreadyFinishedException ex) {
        logger.error(ex.getMessage());
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

}
