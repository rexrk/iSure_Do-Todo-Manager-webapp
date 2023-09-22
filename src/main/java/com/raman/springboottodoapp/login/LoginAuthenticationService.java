package com.raman.springboottodoapp.login;

import org.springframework.stereotype.Service;

@Service
public class LoginAuthenticationService {

    public boolean authenticate(String name, String pass) {
        boolean nameVerified = name.equalsIgnoreCase("raman");
        boolean passVerified = pass.equalsIgnoreCase("root");
        return nameVerified && passVerified;

    }
}