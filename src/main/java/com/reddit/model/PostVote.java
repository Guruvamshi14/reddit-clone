package com.reddit.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PostVote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "post_id")
    Post post;
    //@ManyToOne
    //@JoinColumn(name = "user_id")
  //  User user;
     @Enumerated(EnumType.STRING)
    VoteType voteType;
}

