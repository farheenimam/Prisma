package com.prizma.prizma.Author;

import com.prizma.prizma.Reader.ConnectReader;
import com.prizma.prizma.Register.ConnectUser;
import com.prizma.prizma.Register.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service // Logic
public class AuthorMainController {

    @Autowired
    private ConnectAuthor connectAuthor;

    @Autowired
    private ConnectUser connectUser;
    private User user;

    private Author authors;

    @Autowired
    private ConnectReader connectReader;

    public IncomeInfo findAuthorIncome(String author) {
        return connectReader.findAuthorIncome(author);
    }
    @Controller
    public static class ListAuthorsController {

        @Autowired
        private ConnectAuthor connectAuthor;

        @GetMapping("/authors")
        public String displayListAuthors(Model model){
            List<Author> authors = connectAuthor.findAuthors();
            model.addAttribute("authors", authors); // Add authors to model
            return "authors";
        }
    }
}
