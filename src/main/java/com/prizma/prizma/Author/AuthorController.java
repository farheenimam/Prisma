package com.prizma.prizma.Author;

import com.prizma.prizma.Register.ConnectUser;
import com.prizma.prizma.Register.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorController {

    @Autowired
    private ConnectUser connectUser;
    @Autowired
    private AuthorOperation authorOperation;

    private User user;
    @GetMapping("/authorAddBook")
    public String showForm(){
        return "authorAddBook";
    }

    // APi endpoint for adding an author
    @PostMapping("/addAuthor") // Maps the post request to /addAuthor endpoint
    // Maps HTTP POST Request to addAuthor data
    public String addAuthor(@RequestParam("email") String email, // Using request parameter to extract data from the form
                            @RequestParam("name") String name,
                            @RequestParam("book") String book,
                            Model model) {

        User existingAuthor = connectUser.findByEmail(email);
        if (existingAuthor == null) {
            throw new RuntimeException("Author not found. Please input a valid Author");
        } else {
            try {
                // Creates a author object and save it
                Author author = new Author(email, book, name);
                authorOperation.addAuthor(author); // save data using addAuthor function in database
                return "redirect:/authorDashboard";
            } catch (Exception e) {
                model.addAttribute("error", "An error occurred while adding the author. Please try again.");
                return "authorAddBook";
            }
        }
    }
}
