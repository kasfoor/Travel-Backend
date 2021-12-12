package com.travelbackend.travelbackend.microservices.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/review")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> getReviews (){
        return reviewService.getReviews();
    }

    @PostMapping
    public void addNewReview(@RequestBody Review review){reviewService.addNewReview(review); }

    @DeleteMapping(path="{destId}")
    public void deleteReview(@PathVariable("destId") Long destId){
        reviewService.deleteReview(destId);
    }


}
