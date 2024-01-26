package com.example.dealo_backend.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "conversation")
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;

    @ManyToOne
    @JoinColumn(name = "buyer_id", nullable = false)
    private User buyer;

    @Column(name = "read_by_seller")
    private boolean readBySeller;

    @Column(name = "read_by_buyer")
    private boolean readByBuyer;

    @Column(name = "last_message", length = 1000, nullable = false)
    private String lastMessage;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }
}
