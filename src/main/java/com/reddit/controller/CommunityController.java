package com.reddit.controller;

import com.reddit.dto.CommunityDto;
import com.reddit.model.CommunityType;
import com.reddit.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityService communityService;

    @GetMapping("/community/new")
    public String showCreateForm(Model model) {
        model.addAttribute("communityDto", new CommunityDto());
        model.addAttribute("typeOptions", CommunityType.values());
        // Add all topics list from your static source or enum
        model.addAttribute("topicsList", List.of("Food & Recipes", "Baking & Desserts", "Vegetarian & Vegan Food"));
        return "community_form";
    }

    @PostMapping("/community/new")
    public String createCommunity(@ModelAttribute CommunityDto dto) {
        communityService.createCommunity(dto);
        return "redirect:/communities";
    }
}

