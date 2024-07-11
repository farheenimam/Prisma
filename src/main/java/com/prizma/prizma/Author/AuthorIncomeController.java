package com.prizma.prizma.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorIncomeController {

    @Autowired
    private AuthorMainController authorOperation;

    @GetMapping("/authincome")
    public String showAuthorIncome() {
        return "authincome";
    }

    @PostMapping("/fetchIncome")
    public String fetchIncome(@RequestParam("authorName") String authorName, Model model) {
        try {
            IncomeInfo incomeInfo = authorOperation.findAuthorIncome(authorName);
            if (incomeInfo == null) {
                model.addAttribute("error", "No income found for the specified author.");
            } else {
                model.addAttribute("name", incomeInfo);
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "authincome";
    }
}
