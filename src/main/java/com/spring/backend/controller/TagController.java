package com.spring.backend.controller;

import com.spring.backend.entity.Tag;
import com.spring.backend.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public String tagPage(Model model) {
        model.addAttribute("taglist", tagService.getAllTags());
        return "viewtag";
    }

    @GetMapping("/addtag")
    public String showRegForm(Model model) {
        Tag tag = new Tag();
        model.addAttribute("tag",tag);
        return "addtag";
    }

    @PostMapping("/createtag")
    public String createTag(@ModelAttribute("tag") Tag tag) {
        tagService.createTag(tag);
        return "redirect:/";
    }
}
