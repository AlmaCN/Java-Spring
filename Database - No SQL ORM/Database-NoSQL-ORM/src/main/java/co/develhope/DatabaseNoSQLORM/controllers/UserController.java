package co.develhope.DatabaseNoSQLORM.controllers;

import co.develhope.DatabaseNoSQLORM.entities.User;
import co.develhope.DatabaseNoSQLORM.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/see-users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

}
