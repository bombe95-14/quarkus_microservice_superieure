package spring.auth.keycloak.authentication_service.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    private final JwtAuthConverter jwtAuthConverter;

    public WebSecurityConfig(JwtAuthConverter jwtAuthConverter) {
        this.jwtAuthConverter = jwtAuthConverter;
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> {
            web.ignoring().requestMatchers(HttpMethod.GET, "public/**") // Allow public access to GET requests
                    .requestMatchers(HttpMethod.POST, "public/**") // Allow public access to POST requests
                    .requestMatchers(HttpMethod.PUT, "public/**") // Allow public access to PUT requests
                    .requestMatchers(HttpMethod.DELETE, "public/**"); // Allow public access to DELETE requests
            // You can add more matchers as needed
            // This will ignore security for the specified paths
            // Adjust the paths according to your application's requirements
            // For example, you might want to ignore static resources or specific endpoints 
                };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            //.csrf().disable()
            .authorizeHttpRequests( authorize -> authorize
                .requestMatchers("/api/users/**").hasRole("ADMIN") // Restrict access to user endpoints to ADMIN role
                .anyRequest().authenticated() // All other requests must be authenticated
            )
           .oauth2ResourceServer( 
                oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthConverter) ) // Use JWT authentication converter
            ).sessionManagement(  
                session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Use stateless sessions
            ).build();
    }

}
