package com.travelbackend.travelbackend.microservices.Recommendation;

import com.travelbackend.travelbackend.microservices.Destination.Destination;
import com.travelbackend.travelbackend.microservices.Destination.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/recommendation")
public class RecommendationController {

    private final RecommendationService recommendationService;

    @Autowired
    public RecommendationController(RecommendationService recommendationService){
        this.recommendationService = recommendationService;
    }

    @GetMapping
    public List<Recommendation> getRecommendations (){
        return recommendationService.getRecommendations();
    }

    @PostMapping
    public void addNewRecommendation(@RequestBody Recommendation recommendation){recommendationService.addNewRecommendation(recommendation); }

    @DeleteMapping(path="{destId}")
    public void deleteRecommendation(@PathVariable("destId") Long destId){
        recommendationService.deleteRecommendation(destId);
    }

}
