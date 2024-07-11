package com.prizma.prizma.Login;

import com.prizma.prizma.Register.User;
import com.prizma.prizma.SessionExpiredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired // To instantiate loginuser
    private LoginUser loginUser;

    @GetMapping
    public String showLoginForm(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping
    public String loginUser(@ModelAttribute User user, Model model){
        try {
            User loggedInUser = loginUser.logginUser(user);

            if ("Reader".equalsIgnoreCase(loggedInUser.getRole())) {
                return "redirect:/readerDashboard";
            }
            if ("Author".equalsIgnoreCase(loggedInUser.getRole())) {
                return "redirect:/authorDashboard";
            }

            return "redirect:/adminDashboard";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "login";
        }
    }


    @GetMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/login";
    }
}
