package com.reddit.controller;

import com.reddit.model.Post;
import com.reddit.service.CommunityService;
import com.reddit.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommunityService communityService;

    // Show form for creating post
    @GetMapping("/createPost")
    public String showCreatePostForm(Model model) {
     //   List<Community> communities = communityService.getAllCommunities();
     //   model.addAttribute("communities", communities);
        model.addAttribute("post", new Post());
        return "createPost";
    }

    @PostMapping("/processPost")
    public String createPost(@ModelAttribute Post post,
                             @RequestParam("communityId") Long communityId,
                             @RequestParam(value = "files", required = false) List<MultipartFile> files) {

      //  postService.createPost(post, communityId, files);

        return "redirect:/posts";
    }
}
