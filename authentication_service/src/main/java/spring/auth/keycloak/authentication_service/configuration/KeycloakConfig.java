package spring.auth.keycloak.authentication_service.configuration;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {

    // @Value("${keycloak.auth-server-url}")
    // private String authServerUrl;


    // @Value("${keycloak.auth-server-url}")
    // private String authServerUrl;

    @Value("${app.keycloak.admin.clientId}")
    private String clientId;

    @Value("${app.keycloak.admin.clientSecret}")
    private String clientSecret;

    @Value("${app.keycloak.realm}")
    private String realm;

    @Value("${app.keycloak.auth-server-url}")
    private String serverUrl;
    
    @Bean
    public Keycloak keycloak() {
        // This is a placeholder for Keycloak configuration.
        // You can add your Keycloak specific beans and configurations here.
        return KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .clientSecret(clientSecret)
                .grantType("client_credentials")
                .realm(realm)
                .clientId(clientId)
              //  .username("your-username")
               // .password("your-password")
                .build();
    }

}
