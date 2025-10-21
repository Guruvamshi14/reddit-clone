package com.reddit.service;

import com.reddit.model.*;

import com.reddit.repositories.CommunityRepository;
import com.reddit.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommunityRepository communityRepository;

    @Override
    public void createPost(Post post, Long communityId, List<MultipartFile> files, User user) {

    }



}
