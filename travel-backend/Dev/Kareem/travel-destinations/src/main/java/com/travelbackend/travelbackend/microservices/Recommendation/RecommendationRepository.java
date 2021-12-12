package com.travelbackend.travelbackend.microservices.Recommendation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation,Long>{

    Optional<Recommendation> findRecommendationByAuthor(String author);
}
