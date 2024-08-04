package com.ramramv.estate_search.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthConverter jwtAuthConverter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req -> req
                        .requestMatchers("/public/**").permitAll()
                        .anyRequest().authenticated())
                .oauth2ResourceServer(oauth2 -> {
                    oauth2.jwt(jwt -> {
                        // jwt.decoder(jwtDecoder());
                        jwt.jwtAuthenticationConverter(jwtAuthConverter);
                    });
                });

        http.sessionManagement(session -> {
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        });

        return http.build();
    }

    // @Bean
    // public JwtDecoder jwtDecoder() {
    // return NimbusJwtDecoder.withJwkSetUri(jwkSetUri).build();
    // }

    // @Bean
    // public JwtAuthenticationConverter jwtAuthenticationConverter() {
    // JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
    // converter.setJwtAuthenticationConverter(new JwtAuthConverter());
    // return converter;
    // }

    // @Bean
    // public SessionAuthenticationStrategy sessionAuthenticationStrategy() {
    // return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    // }

    // @Bean
    // public JwtDecoder jwtDecoder() {
    // String jwkSetUri =
    // "http://localhost:8081/auth/realms/myrealm/protocol/openid-connect/certs";
    // return NimbusJwtDecoder.withJwkSetUri(jwkSetUri).build();
    // }
}
