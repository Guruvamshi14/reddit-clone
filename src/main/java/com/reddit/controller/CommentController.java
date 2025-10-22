package com.reddit.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {

    @PostMapping("/addComment")
    public String addComment(){
       return "comment";
    }

    @DeleteMapping("/deleteComment")
    public String deleteComment(){
        return "comment";
    }

    @GetMapping("/seeComments")
    public String seeComments(){
        return "comment";
    }

    @PostMapping("/upvoteDownvote")
    public String upvoteDownvote(){
        return "comment";
    }
}
