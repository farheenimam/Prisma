package com.prizma.prizma.Register;


import com.prizma.prizma.Reader.ConnectReader;
import com.prizma.prizma.Reader.Reader;
import com.prizma.prizma.Register.ConnectUser;
import com.prizma.prizma.Register.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userProfile")
public class ProfileController {

    @GetMapping
    public String getProfile(Model model){
        return "userProfile"; // Return the name of your HTML template
    }
}