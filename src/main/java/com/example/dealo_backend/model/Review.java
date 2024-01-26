package com.example.dealo_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.util.Date;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "review")
public class Review {

    public enum Stars {
        ONE, TWO, THREE, FOUR, FIVE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Stars must be provided")
    @Column(name = "stars", nullable = false)
    private Stars stars;

    @Column(name = "content", nullable = false, length = 1000)
    private String content;

    @Column(name = "helpful_yes")
    private int helpfulYes;

    @Column(name = "helpful_no")
    private int helpfulNo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;


    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    public int getHelpfulYes() {
        return helpfulYes;
    }

    public void setHelpfulYes(int helpfulYes) {
        this.helpfulYes = helpfulYes;
    }
}
