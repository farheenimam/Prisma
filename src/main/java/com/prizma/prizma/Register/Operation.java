package com.prizma.prizma.Register;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

@Service // Service is used for logic purpose
public class Operation {

    private final ConnectUser connectUser;

    @Autowired
    public Operation(ConnectUser connectUser) {
        this.connectUser = connectUser;
    }

    private String encodePassword(String password) throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        // Used Secured hashed algorithm
        MessageDigest m = MessageDigest.getInstance("SHA-512");
        m.update(salt);

        byte[] hashedPassword = m.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashedPassword) + ":" + Base64.getEncoder().encodeToString(salt);
    }

    @Transactional
    public User register(User user) throws NoSuchAlgorithmException {
        User existingUser = connectUser.findByEmail(user.getEmail());
        User existingUserName = connectUser.findByUsername(user.getName());
        if (existingUser != null) {
            throw new RuntimeException("User with this email already exists");
        }
        if (existingUserName != null) {
            throw new RuntimeException("User with this name already exists");
        }
        String hashedPassword = encodePassword(user.getPassword());
        user.setPassword(hashedPassword);
        return connectUser.save(user);
    }

    public User findAuthor(String name) {
        return connectUser.findByUsername(name);
    }

    public User findReader(String name){
        return connectUser.findByUsername(name);
    }
}
