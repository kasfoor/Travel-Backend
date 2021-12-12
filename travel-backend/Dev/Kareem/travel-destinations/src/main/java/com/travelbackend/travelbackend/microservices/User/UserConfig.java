package com.travelbackend.travelbackend.microservices.User;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner userLineRunner(UserRepository repository){
        return args -> {
            Users user1 = new Users(
                    "Kareem Asfoor",
                    "password",
                    "kasfoor@csus.edu",
                    true
            );

            Users user2 = new Users(
                    "John Smith",
                    "password",
                    "john@csus.edu",
                    false
            );

            repository.save(user1);
            repository.save(user2);
        };
    }
}
