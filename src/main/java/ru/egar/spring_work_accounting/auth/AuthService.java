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
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final AuthRequestMapper authRequestMapper;


    @Transactional
    public void register(AuthRequest authRequest) {
        var account = authRequestMapper.map(authRequest);
        if (accountRepository.findByLogin(account.getLogin()).isPresent()) {
            final String exceptionMessage = "This user is already exist";
            throw new AccountIsAlreadyExistsException(exceptionMessage);
        }
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setRole(Role.EMPLOYEE);
        accountRepository.save(account);
        jwtService.generateToken(account);
    }

    public String authenticate(AuthRequest authRequest) {
        var account = accountRepository.findByLogin(authRequest.getLogin());
        if (account.isEmpty()) {
            final String exceptionMessage = "Account with such login not exist";
            throw new AccountNotFoundException(exceptionMessage);
        }
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getLogin(), authRequest.getPassword())
        );
        return jwtService.generateToken(account.get());
    }
    
}