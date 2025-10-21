package com.reddit.dto;

import com.reddit.model.CommunityType;
import lombok.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommunityDto {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    private String bannerImageUrl;
    private String iconImageUrl;

    @NotNull
    private CommunityType type;

    private boolean mature;

    @Size(min = 1, max = 3)
    private List<String> topics;

    private List<Long> allowedMemberIds;
    private List<Long> postIds;
    private List<String> rules;
}
