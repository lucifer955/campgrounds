package com.spring.backend.controller;

import com.spring.backend.entity.Campground;
import com.spring.backend.entity.Tag;
import com.spring.backend.entity.User;
import com.spring.backend.entity.UserProfile;
import com.spring.backend.repository.TagRepository;
import com.spring.backend.repository.UserProfileRepository;
import com.spring.backend.service.CampgroundService;
import com.spring.backend.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CampgroundController {

    @Autowired
    private CampgroundService campgroundService;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private TagRepository tagRepository;

    //get all campgrounds
    @GetMapping("/")
    public String campgroundPage(Model model) {
        List<Tag> tagList = tagRepository.findAll();
        model.addAttribute("tagList",tagList);
        model.addAttribute("campgroundlist",campgroundService.getAllCampgrounds());

        return "index";
    }

    //create a campground page
    @GetMapping("/addcampground")
    public String showCampgroundCreatePage(Model model) {
        List<UserProfile> userProfileList = userProfileRepository.findAll();
        List<Tag> tagList =  tagRepository.findAll();
        model.addAttribute("userProfileList", userProfileList );
        Campground campground = new Campground();
        model.addAttribute("campground",campground);
        model.addAttribute("tagList",tagList);
        return "addcampground";
    }

    @GetMapping("/campground/{id}")
    public String viewCampground(@PathVariable(value = "id") Long id, Model model) {
        Campground campground = campgroundService.getCampground(id);
        model.addAttribute("campgrounddetails",campground);
        List<Tag> tagList = tagRepository.findAll();
        model.addAttribute("tagList",tagList);
        return "campground";
    }

    //save campground to database
    @PostMapping("/createcampground")
    public String createCampground(@ModelAttribute("campground") Campground campground) {
        campgroundService.createCampground(campground);
        return "redirect:/";
    }
}
