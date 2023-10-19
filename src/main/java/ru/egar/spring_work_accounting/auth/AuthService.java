package ru.egar.spring_work_accounting.auth;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class AuthService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RegisterRequestMapper registerRequestMapper;

    @Transactional
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var account = registerRequestMapper.map(registerRequest);
        if (accountRepository.findByLogin(account.getLogin()).isPresent()) {
            final String exceptionMessage = "This user is already exist";
            throw new AccountIsAlreadyExistsException(exceptionMessage);
        }
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setRole(Role.EMPLOYEE);
        account.setIsDeleted(false);
        accountRepository.save(account);
        String jwtToken = jwtService.generateToken(account);
        return AuthenticationResponse.builder()
                .accountId(account.getId())
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthRequest authRequest) {
        var account = accountRepository.findByLogin(authRequest.getLogin());
        if (account.isEmpty() || account.get().getIsDeleted()) {
            final String message = "Account with provided login not found";
            throw new AccountNotFoundException(message);
        }
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getLogin(), authRequest.getPassword())
        );
        String jwtToken = jwtService.generateToken(account.get());
        return AuthenticationResponse.builder()
                .accountId(account.get().getId())
                .token(jwtToken)
                .build();
    }

}