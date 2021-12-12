package com.travelbackend.travelbackend.microservices.Recommendation;

import com.travelbackend.travelbackend.microservices.Destination.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;

    @Autowired
    public RecommendationService(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    public List<Recommendation> getRecommendations () {return recommendationRepository.findAll();}

    public void addNewRecommendation(Recommendation recommendation){
        Optional<Recommendation> recommendationByAuthor = recommendationRepository.findRecommendationByAuthor(recommendation.getAuthor());
        if(recommendationByAuthor.isPresent()){
            throw new IllegalStateException("Recommendation already exists in table");
        }
        recommendationRepository.save(recommendation);
    }

    public void deleteRecommendation(Long destId){
        boolean exists = recommendationRepository.existsById(destId);
        if(!exists){
            throw new IllegalStateException("Desitination with id: " + destId + "does not exist.");
        }
        recommendationRepository.deleteById(destId);
    }
}
