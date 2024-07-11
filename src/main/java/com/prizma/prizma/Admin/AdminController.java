package com.prizma.prizma.Admin;

import com.prizma.prizma.Author.Author;
import com.prizma.prizma.Author.ConnectAuthor;
import com.prizma.prizma.Reader.ConnectReader;
import com.prizma.prizma.Reader.Reader;
import com.prizma.prizma.Register.ConnectUser;
import com.prizma.prizma.Register.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private ConnectAuthor connectAuthor;

    @Autowired
    private ConnectReader connectReader;

    @Autowired
    private ConnectUser connectUser;

    @GetMapping("/manageauthors")
    public String displayAuthorsInfo(Model model){
        List<Author> authors = connectAuthor.findAll();
        model.addAttribute("authors", authors);
        return "manageauthors";
    }

    @GetMapping("/managereaders")
    public String displayReadersInfo(Model model){
        List<Reader> readers = connectReader.findAll();
        model.addAttribute("readers", readers);
        return "managereaders";
    }

    @GetMapping("/adminDashboard")
    public String displayUsersInfo(Model model){
        List<User> users = connectUser.findAll();
        model.addAttribute("users", users);
        return "adminDashboard";
    }

    @PostMapping("/deleteUser/{id}")
    // @PathVariable annotation is used to extract a variable from the URI path and map it to a method parameter
    public String deleteUser(@PathVariable("id") Long id) {
        connectUser.deleteById(id);
        return "redirect:/adminDashboard";
    }

    @PostMapping("/removeReader/{id}")
    public String removeReader(@PathVariable("id") Long id) {
        connectReader.deleteById(id);
        return "redirect:/managereaders";
    }

    @PostMapping("/removeAuthor/{id}")
    public String removeAuthor(@PathVariable("id") Long id) {
        connectAuthor.deleteById(id);
        return "redirect:/manageauthors";
    }

}
