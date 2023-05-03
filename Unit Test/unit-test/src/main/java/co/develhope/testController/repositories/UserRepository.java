package co.develhope.testController.repositories;

import co.develhope.testController.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}