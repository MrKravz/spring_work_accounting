package ru.egar.spring_work_accounting.task;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.egar.spring_work_accounting.abstraction.exceptions.ExceptionResponse;
import ru.egar.spring_work_accounting.employee.employee_interaction.TaskIsAlreadyFinishedException;
import ru.egar.spring_work_accounting.employee.employee_interaction.TaskIsAlreadyStartedException;

import java.time.LocalDateTime;

@ControllerAdvice
public class TaskExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = TaskNotCreatedException.class)
    public ResponseEntity<ExceptionResponse> handleTaskNotCreatedException(TaskNotCreatedException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = TaskNotUpdatedException.class)
    public ResponseEntity<ExceptionResponse> handleTaskNotUpdatedException(TaskNotUpdatedException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = TaskNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleTaskNotFoundException(TaskNotFoundException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = TaskIsAlreadyStartedException.class)
    public ResponseEntity<ExceptionResponse> handleTaskIsAlreadyStartedException(TaskIsAlreadyStartedException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = TaskIsAlreadyFinishedException.class)
    public ResponseEntity<ExceptionResponse> handleTaskIsAlreadyFinishedException(TaskIsAlreadyFinishedException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

}
