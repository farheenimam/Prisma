package com.prizma.prizma.Register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Manages api
@Controller // To develop api
@RequestMapping("/register")
public class RegisterController {

    private final Operation operation;

    @Autowired // Create instants
    public RegisterController(Operation operation) {
        this.operation = operation;
    }

    @GetMapping // Handles get request
    public String register(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping // Handles post request
    public String registerUser(@ModelAttribute User user, Model model) {
        try {
            User registeredUser = operation.register(user);
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }
}
