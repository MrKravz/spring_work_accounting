package ru.egar.spring_work_accounting.auth;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class AuthController {

    private final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final AuthService authService;

    @GetMapping
    public String index() {
        return "mainViews/index";
    }


    @GetMapping("/auth/register")
    public String register(@ModelAttribute AuthRequest authRequest) {
        return "authViews/register";
    }

    @PostMapping("/auth/register")
    public String createAccount(@ModelAttribute("authRequest") AuthRequest authRequest) {
        authService.register(authRequest);
        return "mainViews/index";
    }

    @GetMapping("/auth/login")
    public String login(@ModelAttribute AuthRequest authRequest) {
        return "authViews/auth";
    }

    @PostMapping("/auth")
        public String auth(@ModelAttribute("authRequest") AuthRequest authRequest) {
        var token = authService.authenticate(authRequest);
        logger.info(token);
        return "mainViews/index";
    }

}
