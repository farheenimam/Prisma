package com.prizma.prizma.Reader;

import com.prizma.prizma.Register.ConnectUser;
import com.prizma.prizma.Register.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderOperation {
    //  Autowired is used for dependency injection
    @Autowired // Inject instance of the class in the constructor
    private ConnectUser connectUser;

    @Autowired
    private ConnectReader connectReader;


    // To save the purchase of the user that buys the books
    @Transactional //  It rolls back the transaction to prevent partial updates and maintain data integrity.
    public Reader purchase(Reader reader){
        Reader alreadyPurschased = connectReader.findByEmailBookAndAuthor(reader.getEmail(), reader.getAuthor());
        if (alreadyPurschased != null) {
            throw new RuntimeException("You have already bought this book.");
        }

        // Retrieve user details based on email
        User user = connectUser.findByEmail(reader.getEmail());
        if (user == null) {
            throw new RuntimeException("User not found with the provided email.");
        }

        // Save the reader details to the Reader table
        return connectReader.save(reader);
    }
}
