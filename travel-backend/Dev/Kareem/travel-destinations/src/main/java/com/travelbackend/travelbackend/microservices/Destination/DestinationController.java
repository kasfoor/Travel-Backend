package com.travelbackend.travelbackend.microservices.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/destination")
public class DestinationController {

    private final DestinationService destinationService;

    @Autowired
    public DestinationController(DestinationService destinationService){
        this.destinationService = destinationService;
    }

    @GetMapping
    public List<Destination> getDestinations (){
        return destinationService.getDestinations();
    }

    @PostMapping
    public void addNewDestination(@RequestBody Destination destination){destinationService.addNewDestination(destination); }

    @DeleteMapping(path="{destId}")
    public void deleteDestination(@PathVariable("destId") Long destId){
        destinationService.deleteDestination(destId);
    }

}
