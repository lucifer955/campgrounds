package com.spring.backend.controller;

import com.spring.backend.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

//    //gell all users
//    @GetMapping("/addcampground")
//    public String userProfilePage(Model model) {
//        model.addAttribute("userProfileList",userProfileService.getAllUserProfiles());
//        return "addcampground";
//    }
}
