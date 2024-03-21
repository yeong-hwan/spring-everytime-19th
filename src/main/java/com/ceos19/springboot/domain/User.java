package com.ceos19.springboot.domain;
import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDateTime;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 20)
    private String username;

    @Column(nullable = false, length = 12)
    private String password;

    @Column(nullable = false, length = 10)
    private String nickname;

    @Column(nullable = false)
    private Boolean isAdmin;

    @Column(nullable = false, length = 20)
    private String userLast;

    @Column(nullable = false, length = 20)
    private String userFirst;

    @Column(nullable = false, length = 20)
    private String email;

    @Column(nullable = false)
    private Boolean isBoardManager;

    @Column(nullable = false, length = 20)
    private String board;

    @Column(nullable = false)
    private Boolean isBanned;

    // TemporalType.TIMESTAMP
    @Column(nullable = true, length = 20)
    private LocalDateTime createdAt;

    @Column(nullable = true, length = 20)
    private LocalDateTime lastLogin;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "school_id")
    private School school;

    @Builder
    public User(final String username, final String password, final String nickname,
                final Boolean isAdmin, final String userLast, final School school,
                final String userFirst, final String email, final Boolean isBoardManager,
                final String board, final Boolean isBanned, final LocalDateTime createdAt,
                final LocalDateTime lastLogin) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.isAdmin = isAdmin;
        this.userLast = userLast;
        this.userFirst = userFirst;
        this.email = email;
        this.isBoardManager = isBoardManager;
        this.board = board;
        this.isBanned = isBanned;
        this.createdAt = createdAt;
        this.lastLogin = lastLogin;
        this.school = school;
    }
}
