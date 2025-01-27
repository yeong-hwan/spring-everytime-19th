package com.ceos19.springboot.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 65535)
    private String content;

    @Column(nullable = false, length = 10)
    private Long likeCount;

    @Column(nullable = false, length = 10)
    private Long reportCount;

    @Column(nullable = false, length = 10)
    private Long scrap;

    @Column(nullable = false, length = 20)
    private LocalDateTime createdAt;

    @Column(nullable = false, length = 20)
    private LocalDateTime editedAt;

    @Column(nullable = false)
    private boolean isAnonymous;

    @Column(nullable = false, length = 65535)
    private String filePath;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "board_id")
    private Board board;
}
