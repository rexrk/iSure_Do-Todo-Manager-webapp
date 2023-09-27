package com.raman.springboottodoapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager configureUserDetailsManager() {

        Function<String, String> passwordEncoder = this::apply;
        UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder)
                .username("raman").password("root")
                .roles("USER", "ADMIN").build();

        return new InMemoryUserDetailsManager(userDetails);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private String apply(String s) {
        return passwordEncoder().encode(s);
    }
}
