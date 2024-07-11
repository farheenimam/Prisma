package com.prizma.prizma;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InformationController {

    @GetMapping("/aboutus.html")
    String showaboutus(){
        return "aboutus";
    }

}
