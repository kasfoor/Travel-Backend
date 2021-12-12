package com.travelbackend.travelbackend;

import com.travelbackend.travelbackend.microservices.Destination.Destination;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class TravelBackendApplication {

	@GetMapping("/")
	public String home(){
		return "Welcome to Travel Backend Application";
	}


	public static void main(String[] args) {
		SpringApplication.run(TravelBackendApplication.class, args);
	}

}
