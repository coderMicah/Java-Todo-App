package com.micah.todoApp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String name, String password) {
        if (name.equalsIgnoreCase("micah") && password.equalsIgnoreCase("1234")) {
            return true;
        }
        return false;
    }
}
