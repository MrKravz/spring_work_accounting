package ru.egar.spring_work_accounting.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.egar.spring_work_accounting.auth.JwtFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/auth/**", "/resources/**", "/", "/css", "/img", "/static/**").permitAll()
                        .requestMatchers("/available_tasks/**").hasRole("EMPLOYEE")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .sessionManagement(httpSecuritySessionManagementConfigurer ->
                        httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin(form -> form
                        .loginPage("/auth/login")
                        .permitAll())
                .logout((logout) -> logout
                        .logoutSuccessUrl("/")
                        .clearAuthentication(true)
                        .permitAll()
                );
        return http.build();
    }

}
