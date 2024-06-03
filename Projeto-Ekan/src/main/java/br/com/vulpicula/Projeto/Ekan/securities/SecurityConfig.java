package br.com.vulpicula.Projeto.Ekan.securities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorizeConfig -> {
                    authorizeConfig.requestMatchers("/api/usuarios/criar", "/api/usuarios/login").permitAll();  // Permitir a criação e login de usuários
                    authorizeConfig.requestMatchers("/api/usuarios/**").hasRole("ADMIN"); // Requerer papel 'ADMIN' para outras URLs de usuários
                    authorizeConfig.requestMatchers("/api/beneficiarios/**", "/api/documentos/**").hasAnyRole("ADMIN", "COMUM"); // Requerer qualquer papel para URLs de beneficiários e documentos
                    authorizeConfig.anyRequest().authenticated(); // Requerer autenticação para outras URLs
                })
                .oauth2Login(Customizer.withDefaults())
                .oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults())
                )
                .build();
    }
}
