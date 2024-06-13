package com.micah.todoApp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
    // LDAP OR Database --> we store username in either of these

    // InMemoryUserDetailsManager
    // InMemoryUserDetailsManager(UserDetails... users)

    @Bean
    public InMemoryUserDetailsManager createUserDetails() {

        UserDetails user1 = createNewUser("Micah", "1234");
        UserDetails user2 = createNewUser("John", "1234");

        return new InMemoryUserDetailsManager(user1,user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private UserDetails createNewUser(String username,String password){
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);


         UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder)
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
                
        return userDetails;
    }
}
