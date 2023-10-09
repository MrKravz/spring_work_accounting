package ru.egar.spring_work_accounting.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("register")
    public String register() {
        return "authViews/register";
    }

    @PostMapping("register")
    public String createAccount() {
        authService.createAccount();
        return "redirect:/mainViews/index";
    }

    @GetMapping("auth")
    public String login() {
        return "authViews/auth";
    }

    @PostMapping("auth")
    public String auth() {
        authService.authenticate();
        return "redirect:/mainViews/index";
    }

}
