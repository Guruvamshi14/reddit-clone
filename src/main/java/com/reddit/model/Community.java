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

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    private String bannerImageUrl;
    private String iconImageUrl;

    @Enumerated(EnumType.STRING)
    private CommunityType type;

    private boolean mature;

    @ElementCollection
    @CollectionTable(name = "community_topics", joinColumns = @JoinColumn(name = "community_id"))
    @Column(name = "topic")
    private List<String> topics;

    @ManyToMany
    @JoinTable(
            name = "community_allowed_members",
            joinColumns = @JoinColumn(name = "community_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> allowedMembers;

    @OneToMany(mappedBy = "community",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;

    private LocalDateTime createdDate;

    @ManyToOne
    @JoinColumn(name = "owner_id",nullable = false)
    private User owner;

    @ElementCollection
    @CollectionTable(name = "community_rules",joinColumns = @JoinColumn(name = "community_id"))
    @Column(name = "rule")
    private List<String> rules;
}


