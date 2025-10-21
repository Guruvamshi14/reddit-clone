package com.reddit.service;

import com.reddit.dto.CommunityDto;
import com.reddit.model.Community;
import com.reddit.repo.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {

    private final CommunityRepository communityRepo;
//    private final UserRepository userRepo; // Assume you have this

    @Override
    public Community createCommunity(CommunityDto dto) {
        Community community = Community.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .bannerImageUrl(dto.getBannerImageUrl())
                .iconImageUrl(dto.getIconImageUrl())
                .type(dto.getType())
                .mature(dto.isMature())
                .topics(dto.getTopics())
                .createdDate(LocalDateTime.now())
                .rules(dto.getRules())
                .build();

        // Allowed members logic
        if (dto.getAllowedMemberIds() != null) {
//            community.setAllowedMembers(userRepo.findAllById(dto.getAllowedMemberIds()));
        }
        // Posts logic can be added similarly
        return communityRepo.save(community);
    }

    @Override
    public Optional<Community> findByName(String name) {
        return communityRepo.findByName(name);
    }
}
