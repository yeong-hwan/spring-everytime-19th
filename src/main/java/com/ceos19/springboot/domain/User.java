package com.ceos19.springboot.domain;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class User extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long userId;

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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "school_id")
    private School school;

    @Builder
    public User(final String username, final String password, final String nickname,
                final Boolean isAdmin, final String userLast, final School school,
                final String userFirst, final String email, final Boolean isBoardManager,
                final String board, final Boolean isBanned) {
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
        this.school = school;
    }
}
