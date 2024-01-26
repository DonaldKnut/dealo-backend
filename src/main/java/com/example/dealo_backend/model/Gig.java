package com.example.dealo_backend.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "gig")
public class Gig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "short_title") // Add shortTitle column
    private String shortTitle;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "cover_image")
    private byte[] coverImage;

    @ElementCollection
    @CollectionTable(name = "upload_images", joinColumns = @JoinColumn(name = "gig_id"))
    @Column(name = "image", nullable = false)
    private List<byte[]> uploadImages;

    @Column(name = "description", nullable = false, length = 1000)
    private String description;

    @Column(name = "delivery_time_days", nullable = false)
    private int deliveryTimeDays;

    @Column(name = "revision_number", nullable = false)
    private int revisionNumber;

    @ElementCollection
    @CollectionTable(name = "gig_features", joinColumns = @JoinColumn(name = "gig_id"))
    @Column(name = "feature", nullable = false)
    private List<String> features;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "sales", nullable = false, columnDefinition = "integer default 0")
    private int sales = 0;

    @Column(name = "short_description")
    private String shortDescription;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
