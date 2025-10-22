package com.reddit.controller;

import com.reddit.dto.CommunityDto;
import com.reddit.model.CommunityType;
import com.reddit.service.CommunityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/community")
public class CommunityController {

    private final CommunityService communityService;

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("communityDto", new CommunityDto());
        model.addAttribute("typeOptions", CommunityType.values());
        model.addAttribute("topicsList", List.of(
                "Technology", "Gaming", "Food", "Movies", "Programming", "Fitness"
        ));
        return "community_form";
    }

    @PostMapping("/new")
    public String createCommunity(@ModelAttribute("communityDto") @Valid CommunityDto dto,
                                  BindingResult result,
                                  Model model) {
        if (result.hasErrors()) {
            model.addAttribute("typeOptions", CommunityType.values());
            model.addAttribute("topicsList", List.of(
                    "Technology", "Gaming", "Food", "Movies", "Programming", "Fitness"
            ));
            return "community_form";
        }

        communityService.createCommunity(dto);
        return "redirect:/community/list";
    }

    @GetMapping("/list")
    public String listCommunities(Model model) {
        model.addAttribute("communities", communityService.getAll());
        return "community_list";
    }
}
