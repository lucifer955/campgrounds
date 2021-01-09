package com.spring.backend.controller;

import com.spring.backend.entity.User;
import com.spring.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //get all users
    @GetMapping("/users")
    public String usersPage(Model model) {
        model.addAttribute("userlist",userService.getALlUsers());
        return "viewusers";
    }

    @GetMapping("/adduser")
    public String showUserRegForm(Model model) {
        User user= new User();
        model.addAttribute("user",user);
        return "adduser";
    }

    //register a user
    @PostMapping("/registeruser")
    public String registerUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

//    @PostMapping("/createcampground")
}
