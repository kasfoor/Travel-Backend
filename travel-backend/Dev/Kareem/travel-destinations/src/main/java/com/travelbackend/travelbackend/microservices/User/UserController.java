package com.travelbackend.travelbackend.microservices.User;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){ this.userService = userService;}

    @GetMapping
    public List<Users> getUsers () { return userService.getUsers();}

    @PostMapping
    public void addNewUser(@RequestBody Users users){userService.addNewUser(users);}

    @DeleteMapping(path="{id}")
    public void deleteUser(@PathVariable("id") Long id){userService.deleteUser(id);}
}
