package com.reddit.service;

import com.reddit.dto.CommunityDto;
import com.reddit.model.Community;
import com.reddit.repo.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {

    private final CommunityRepository communityRepo;
    // private final UserRepository userRepo; // Uncomment if you have auth context

    @Override
    public Community createCommunity(CommunityDto dto) {
        if (dto.getTopics() != null && dto.getTopics().size() > 3) {
            throw new IllegalArgumentException("Max 3 topics allowed per community.");
        }

        // TODO: Replace with logged-in user from SecurityContextHolder
        // User owner = userRepo.findById(currentUserId).orElseThrow(...);

        Community community = Community.builder()
                .name(dto.getName().trim())
                .description(dto.getDescription().trim())
                .bannerImageUrl(dto.getBannerImageUrl())
                .iconImageUrl(dto.getIconImageUrl())
                .type(dto.getType())
                .mature(dto.isMature())
                .topics(dto.getTopics())
                .rules(dto.getRules())
                .createdDate(LocalDateTime.now())
                // .owner(owner)
                .build();

        return communityRepo.save(community);
    }

    @Override
    public Optional<Community> findByName(String name) {
        return communityRepo.findByName(name);
    }

    @Override
    public List<Community> getAll() {
        return communityRepo.findAll();
    }
}
