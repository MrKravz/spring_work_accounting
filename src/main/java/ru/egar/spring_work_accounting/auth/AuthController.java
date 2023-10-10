package ru.egar.spring_work_accounting.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("register")
    public String register(@ModelAttribute Account account) {
        return "authViews/register";
    }

    @PostMapping("register")
    public String createAccount() {
        authService.register(null);
        return "mainViews/index";
    }

    @GetMapping("login")
    public String login(@ModelAttribute Account account) {
        return "authViews/auth";
    }

    @PostMapping
    public String auth() {
        authService.authenticate(null);
        return "redirect:/mainViews/index";
    }

}
