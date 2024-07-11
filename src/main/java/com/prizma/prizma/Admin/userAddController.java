package com.prizma.prizma.Admin;

import com.prizma.prizma.Register.Operation;
import com.prizma.prizma.Register.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addUser")
public class userAddController {
    private final Operation operation;

    @Autowired
    public userAddController(Operation operation) {
        this.operation = operation;
    }


    @GetMapping
    public String addUser(){
        return "addUser";
    }

    @PostMapping
    // @ModelAttribute extract values and set to user
    public String registerUser(@ModelAttribute User user, Model model) {
        try {
            User registeredUser = operation.register(user);
            return "redirect:/adminDashboard";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "addUser";
        }
    }
}
