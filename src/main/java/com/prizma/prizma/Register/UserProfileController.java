package com.prizma.prizma.Register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserProfileController {

    @Autowired // Provides Instant
    private Operation operation;

    @GetMapping("/searchReader")
    @ResponseBody // Ensure to return a fragment of HTML directly
    public String searchReader(@RequestParam("name") String name, Model model){
        User reader = operation.findReader(name);
        if (reader != null){
            return "<div class=\"author-info\">" +
                    "<p><strong>Name:</strong> " + reader.getName() + "</p>" +
                    "<p><strong>Email:</strong> " + reader.getEmail() + "</p>" +
                    "<p><strong>Role:</strong> " + reader.getRole() + "</p>" +
                    "</div>";
        }
        else {
            return "<div>No Reader found with the name '" + name + "'.</div>";
        }

    }
}
