package com.reddit.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT",name = "title")
    String title;

    @Column(columnDefinition = "TEXT",name = "content")
    String content;
    @Column(name = "link_url")
    String linkUrl;
    @Column(name = "created_at")
    LocalDate createdAt;
    @Column(name = "updated_at")
    LocalDate updatedAt;
    //@OneToMany
    //@JoinColumn(name = "user_id")
    // User user;


    @ManyToOne
    @JoinColumn(name = "community_id")
    Community community;

    //List<Community> communities;
    @OneToMany
    List<PostMedia> postMedia;

    @OneToMany
    List<PostVote> postVotes;

//    @OneToMany
//    List<Comment> comments;



}
