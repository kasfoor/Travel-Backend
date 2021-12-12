package com.travelbackend.travelbackend.microservices.Destination;

//import com.sun.tools.javac.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DestinationConfig {

    @Bean
    CommandLineRunner destinationLineRunner(DestinationRepository repository){
        return args -> {
            Destination sacramento = new Destination(
                    "Sacramento",
                    "United States",
                    "100.100.100",
                    "200.200.200",
                    1L
            );

            Destination fresno = new Destination(
                    "Fresno",
                    "United States",
                    "300.300.300",
                    "400.400.400",
                    1L
            );

            repository.save(sacramento);
            repository.save(fresno);
        };
    }
}
