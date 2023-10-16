package ru.egar.spring_work_accounting.abstraction.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExceptionResponse {

    public String message;
    public LocalDateTime timeSpan;

}
