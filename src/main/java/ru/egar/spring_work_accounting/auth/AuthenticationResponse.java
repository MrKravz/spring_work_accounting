package ru.egar.spring_work_accounting.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {
    private int accountId;
    private String token;
}
