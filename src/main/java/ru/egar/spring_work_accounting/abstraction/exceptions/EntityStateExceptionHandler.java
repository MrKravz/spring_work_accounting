package ru.egar.spring_work_accounting.abstraction.exceptions;

import org.springframework.http.ResponseEntity;

public interface EntityStateExceptionHandler<T extends EntityStateRelatedException> {

    ResponseEntity<ExceptionResponse> handleEntityStateRelatedException(T ex);

}
