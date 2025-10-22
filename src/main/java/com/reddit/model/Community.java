package com.reddit.model;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    private String bannerImageUrl;
    private String iconImageUrl;

    @Enumerated(EnumType.STRING)
    private CommunityType type; // PUBLIC/RESTRICTED/PRIVATE

    private boolean mature; // 18+

    @ElementCollection
    private List<String> topics; // Max 3

    @ManyToMany
    private List<User> allowedMembers;

    @OneToMany(mappedBy = "community")
    private List<Post> posts;

    private LocalDateTime createdDate;

    @ManyToOne
    private User owner;

    @ElementCollection
    private List<String> rules;
}


