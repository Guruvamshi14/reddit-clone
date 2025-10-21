package com.reddit.service;

import com.reddit.dto.CommunityRequest;
import com.reddit.model.Community;

import java.util.Optional;

public interface CommunityService {
    Community createCommunity(CommunityRequest dto);
    Optional<Community> findByName(String name);

}
