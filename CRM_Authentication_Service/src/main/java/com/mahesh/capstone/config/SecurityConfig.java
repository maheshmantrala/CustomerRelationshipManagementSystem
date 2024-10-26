package com.mahesh.capstone.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors().and() // Enable CORS
            .csrf().disable() // Disable CSRF for simplicity
            .authorizeRequests()
                .requestMatchers("/auth/register", "/auth/login").permitAll() // Allow register and login
                .requestMatchers("/admin-dashboard/**").hasRole("ADMIN")
                .requestMatchers("/customer-dashboard/**").hasRole("CUSTOMER")
                .anyRequest().authenticated() // All other requests need to be authenticated
            .and()
            .formLogin()
                .loginPage("/auth/login") // Custom login page URL
                .defaultSuccessUrl("/dashboard", true) // Redirect to dashboard upon successful login
                .failureUrl("/auth/login?error=true") // Redirect to login page with error message on failure
                .permitAll()
            .and()
            .logout()
                .logoutUrl("/auth/logout") // Custom logout URL
                .logoutSuccessUrl("/auth/login?logout=true") // Redirect to login after logout
                .permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Use BCrypt for password encoding
    }
}