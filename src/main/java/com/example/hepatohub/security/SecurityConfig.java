package com.example.hepatohub.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http

                .csrf().disable()


                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers((RequestMatcher) request -> "/user".equals(request.getServletPath())).permitAll() // Permitir acesso ao endpoint /user sem autenticação
                                .requestMatchers((RequestMatcher) request -> "/swagger-ui.html".equals(request.getServletPath())).permitAll() // Permitir acesso ao Swagger sem autenticação
                                .requestMatchers((RequestMatcher) request -> "/swagger-ui/**".equals(request.getServletPath())).permitAll() // Permitir acesso ao Swagger sem autenticação
                                .anyRequest().authenticated() // Exigir autenticação para todas as outras rotas
                )
                //.formLogin().disable()  Desabilitar login via formulário
                .build(); // Construir o filtro de segurança
    }
}
