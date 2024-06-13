package com.micah.todoApp.security;

import static org.springframework.security.config.Customizer.withDefaults;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
    // LDAP OR Database --> we store username in either of these

    // InMemoryUserDetailsManager
    // InMemoryUserDetailsManager(UserDetails... users)

    @Bean
    public InMemoryUserDetailsManager createUserDetails() {

        UserDetails user1 = createNewUser("Micah", "1234");
        UserDetails user2 = createNewUser("John", "1234");

        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private UserDetails createNewUser(String username, String password) {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

        UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder)
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();

        return userDetails;
    }

    // By default SecurityFilterChain(defines a filter chain against every request )
    // provides these two features
    // All URLS Are protetced
    // Login form is shown for anauthorized users

    // To use H2db we need to add these other features
    // CRSF DISABLE
    // FRAMES

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        http.formLogin(withDefaults());


        http.csrf().disable();
        http.headers().frameOptions().disable();

        return http.build();
    }

}
