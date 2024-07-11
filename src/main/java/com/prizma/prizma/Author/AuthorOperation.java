package com.prizma.prizma.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorOperation {

    @Autowired
    private ConnectAuthor connectAuthor;

    public void addAuthor(Author author) {
        connectAuthor.save(author);
    }
}
