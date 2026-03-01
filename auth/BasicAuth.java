package com.seveneleven.mycontactsapp.auth;

import com.seveneleven.mycontactsapp.user.model.User;
import com.seveneleven.mycontactsapp.user.utilities.PasswordHasher;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public class BasicAuth implements Authentication {

    private final User registeredUser;

    // Constructor that accepts a User
    public BasicAuth(User registeredUser) {
        this.registeredUser = registeredUser;
    }

    @Override
    public Optional<String> login(String email, String password) {
        try {
            String hashedInput = PasswordHasher.hashPassword(password);

            if (registeredUser.getEmail().equals(email) &&
                registeredUser.getPasswordHash().equals(hashedInput)) {
                return Optional.of("Login successful");
            }
        } catch (NoSuchAlgorithmException e) {
            return Optional.empty();
        }
        return Optional.empty();
    }
}
