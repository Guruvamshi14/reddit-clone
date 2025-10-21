package com.reddit.service;

import com.reddit.model.Post;
import com.reddit.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostService {
    void createPost(Post post, Long communityId, List<MultipartFile> files, User user);
}
