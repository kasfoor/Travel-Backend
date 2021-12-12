package com.travelbackend.travelbackend.microservices.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getReviews (){
        return reviewRepository.findAll();
    }

    public void addNewReview(Review review) {
        Optional<Review> reviewByRecommendationid = reviewRepository.findReviewByRecommendationid(review.getRecommendationid());
        if(reviewByRecommendationid.isPresent()){
            throw new IllegalStateException("Review already exists in table");
        }
        reviewRepository.save(review);
    }

    public void deleteReview(Long destId){
        boolean exists = reviewRepository.existsById(destId);
        if(!exists){
            throw new IllegalStateException("Review with id: " + destId + "does not exist.");
        }
        reviewRepository.deleteById(destId);
    }
}
