package com.reddit.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PostMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String mediaUrl;
    @Enumerated(EnumType.STRING)
    MediaType mediaType;
    @ManyToOne
    @JoinColumn(name = "post_id")
    Post post;

}

