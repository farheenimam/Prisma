package com.prizma.prizma.Reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReaderSubscriptionController {

    @Autowired
    private ConnectReader connectReader;

    @GetMapping("/subscriptionList")
    public String showSubscriptionList(Model model) {
        // Code for displaying the form
        return "subscriptionList";
    }

    @PostMapping("/subscriptionSearch")
    public String searchSubscription(@RequestParam("email") String email, Model model) {
        List<Reader> readers = connectReader.findByEmailOfBuyer(email);
        model.addAttribute("readers", readers);
        if (readers.isEmpty()) {
            model.addAttribute("errorMssg", "No subscriptions found for the provided email.");
        }
        return "subscriptionList";
    }
}


