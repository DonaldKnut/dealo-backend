package com.example.dealo_backend.repository;

import com.example.dealo_backend.model.Review;
import com.example.dealo_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByUser(User user);
}

