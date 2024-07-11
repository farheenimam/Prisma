package com.prizma.prizma.Author;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authorDashboard")
public class AuthorDashboardController {

    @GetMapping
    public String showAuthorDashboard(){
        return "authorDashboard";
    }
}

