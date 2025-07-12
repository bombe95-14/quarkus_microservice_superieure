package spring.auth.keycloak.authentication_service.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .requestMatchers("/api/users/**").authenticated() // Restrict access to user endpoints
                .anyRequest().permitAll() // Allow other requests
            .and()
            .httpBasic(); // Use basic authentication

        return http.build();
    }

}
