package com.travelbackend.travelbackend.microservices.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;

    @Autowired
    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public List<Destination> getDestinations (){
        return destinationRepository.findAll();
    }

    public void addNewDestination(Destination destination) {
        Optional<Destination> destinationByPlace = destinationRepository.findDestinationByPlace(destination.getPlace());
        if(destinationByPlace.isPresent()){
            throw new IllegalStateException("Destination already exists in table");
        }
        destinationRepository.save(destination);
    }

    public void deleteDestination(Long destId){
        boolean exists = destinationRepository.existsById(destId);
        if(!exists){
            throw new IllegalStateException("Desitination with id: " + destId + "does not exist.");
        }
        destinationRepository.deleteById(destId);
    }
}
