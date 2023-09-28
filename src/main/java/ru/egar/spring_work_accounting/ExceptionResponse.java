package ru.egar.spring_work_accounting;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponse {
    public String message;
    public long timeSpan;
}
