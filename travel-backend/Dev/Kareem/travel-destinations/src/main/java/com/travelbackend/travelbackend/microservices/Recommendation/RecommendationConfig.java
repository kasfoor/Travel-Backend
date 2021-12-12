package com.travelbackend.travelbackend.microservices.Recommendation;

//import com.sun.tools.javac.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RecommendationConfig {

    @Bean
    CommandLineRunner recommendationLineRunner(RecommendationRepository repository){
        return args -> {
            Recommendation kareem = new Recommendation(
                    "reviewld 1",
                    "kareem",
                    "subject 1",
                    1L
            );

            Recommendation kobe = new Recommendation(
                    "reviewld 2",
                    "kobe",
                    "subject 2",
                    1L
            );

            repository.save(kareem);
            repository.save(kobe);
        };
    }
}
