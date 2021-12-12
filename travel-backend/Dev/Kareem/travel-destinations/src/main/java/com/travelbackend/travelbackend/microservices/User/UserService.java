package com.travelbackend.travelbackend.microservices.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){ this.userRepository = userRepository; }

    public List<Users> getUsers () { return userRepository.findAll(); }

    public void addNewUser(Users users){
        Optional<Users> userById = userRepository.findUserById(users.getId());
        if(userById.isPresent()){
            throw new IllegalStateException("User already exists");
        }
        userRepository.save(users);
    }

    public void deleteUser(Long id){
        boolean exists = userRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("User with id: " + id + "does not exists.");
        }
        userRepository.deleteById(id);
    }
}
