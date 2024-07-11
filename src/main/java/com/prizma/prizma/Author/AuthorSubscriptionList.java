package com.prizma.prizma.Author;

import com.prizma.prizma.Reader.ConnectReader;
import com.prizma.prizma.Reader.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AuthorSubscriptionList {

    @Autowired
    private ConnectReader connectReader;

    @GetMapping("/authorSub")
    public String showAuthorDashboard(Model model) {
        // Display initial view (optional)
        return "authorSub"; // Thymeleaf template name
    }

    @PostMapping("/fetchSubscriptions")
    public String fetchSubscriptions(@RequestParam("author") String author, Model model) {
        // Fetch readers/subscribers based on the author's name
        try {
            List<Reader> readers = connectReader.findAuthor(author);

            // Add fetched readers to the model
            model.addAttribute("readers", readers);
            return "authorSub";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "authorSub";
        }
    }
}
