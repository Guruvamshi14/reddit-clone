package com.reddit.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.time.Instant;
import jakarta.persistence.*;


@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String displayName;

    @Column(nullable = false, unique = true)
    private String uniqueName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private int karma = 0;

    private String profileImageUrl;

    private Instant createdDate = Instant.now();

    @Column(length = 300)
    private String bio;

    private Instant lastLogin;
}
