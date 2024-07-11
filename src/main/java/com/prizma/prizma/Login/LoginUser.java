package com.prizma.prizma.Login;

import com.prizma.prizma.Register.ConnectUser;
import com.prizma.prizma.Register.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class LoginUser {
    @Autowired
    private ConnectUser connectUser;


    /*The checkPassword method takes an entered password, computes its hash using SHA-512 along with a salt, and
    then compares this computed hash with the stored hashed password. This approach ensures passwords are securely verified without storing plain text passwords in the database.*/
    // To check the hashed password the user has nput whether it is incorrect or right
    private boolean checkPassword(String passwordEntered, String passwordStored) throws NoSuchAlgorithmException {
        // To separate the stored password and its salts by  by ':'
        String[] parts = passwordStored.split(":");

        // Decoding the password encoded by 'SHA-512'
        // Salt is a random value added to the password bfr hashing to ensure that identical passwords have diff hashes
        byte[] salt = Base64.getDecoder().decode(parts[1]);
        String storehash = parts[0];

        // This hashes the input value. It takes input salts and generates a fixed size hash value
        MessageDigest m = MessageDigest.getInstance("SHA-512");
        m.update(salt); // ensures that the resulting hash is unique to the combination of pasword and salt

        // Hashes the entered password so it can be compared with the stored password
        byte[] hashedPassword = m.digest(passwordEntered.getBytes());
        String hashedPasswordString = Base64.getEncoder().encodeToString(hashedPassword);

        // Compares both password, return true if match otherwise false
        return hashedPasswordString.equals(parts[0]);
    }

    public User logginUser(User user) throws NoSuchAlgorithmException {
        User storedUser = connectUser.findByEmail(user.getEmail());
        // Find the user by email
        if(storedUser == null){
            throw new RuntimeException("User Not Found");
        }
        // If the entered password and stored password doesnt matches
        if (!checkPassword((user.getPassword()), storedUser.getPassword())){
            throw new RuntimeException("Invalid Password");
        }
        // Returns the authenticated user object
        else
            return storedUser;
    }
}
