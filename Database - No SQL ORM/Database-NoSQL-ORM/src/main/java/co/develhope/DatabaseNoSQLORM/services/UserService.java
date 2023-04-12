package co.develhope.DatabaseNoSQLORM.services;

import co.develhope.DatabaseNoSQLORM.entities.User;
import co.develhope.DatabaseNoSQLORM.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
