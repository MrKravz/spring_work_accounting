package ru.egar.spring_work_accounting.abstraction.exceptions;

import org.springframework.http.ResponseEntity;

public interface EntityExceptionHandler<T extends EntityRelatedException> {

    ResponseEntity<ExceptionResponse> handleEntityRelatedException(T ex);

}
