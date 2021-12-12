package com.travelbackend.travelbackend.microservices.Review;

//import com.sun.tools.javac.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ReviewConfig {

    @Bean
    CommandLineRunner reviewLineRunner(ReviewRepository repository){
        return args -> {
            Review review1 = new Review(
                    "1",
                    "kareem",
                    "5",
                    1L
            );

            Review review2 = new Review(
                    "2",
                    "kobe",
                    "6",
                    1L
            );

            repository.save(review1);
            repository.save(review2);
        };
    }
}
