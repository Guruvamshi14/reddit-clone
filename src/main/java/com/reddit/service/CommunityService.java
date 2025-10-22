package com.reddit.service;

import com.reddit.dto.CommunityDto;
import com.reddit.model.Community;

import java.util.Optional;

public interface CommunityService {
    Community createCommunity(CommunityDto dto);
    Optional<Community> findByName(String name);

}
