package com.example.dealo_backend.controller;

import com.example.dealo_backend.exception.ReviewNotFoundException;
import com.example.dealo_backend.model.Review;
import com.example.dealo_backend.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @PostMapping("/{id}/helpful")
    public ResponseEntity<?> markReviewAsHelpful(@PathVariable Long id) {
        // Retrieve the review from the database
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException("Review not found with id: " + id));

        // Increment the helpfulYes count
        review.setHelpfulYes(review.getHelpfulYes() + 1);
        reviewRepository.save(review);
        System.out.println("Hello World");
        return ResponseEntity.ok().build();
    }

}
