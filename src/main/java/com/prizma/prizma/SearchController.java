package com.prizma.prizma;

import com.prizma.prizma.Register.Operation;
import com.prizma.prizma.Register.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearchController {

    @Autowired
    private Operation operation;

    @GetMapping("/searchAuthor")
    @ResponseBody // Ensure to return a fragment of HTML directly
    public String searchAuthor(@RequestParam("name") String name, Model model) {
        User author = operation.findAuthor(name);
        if (author != null) {
            return "<div class=\"author-info\">" +
                    "<p><strong>Name:</strong> " + author.getName() + "</p>" +
                    "<p><strong>Email:</strong> " + author.getEmail() + "</p>" +
                    "<p><strong>Role:</strong> " + author.getRole() + "</p>" +
                    "</div>";
        }
        else {
            return "<div>No author found with the name '" + name + "'.</div>";
        }
    }
}
