package co.develhope.Login.System.user.repositories;

import co.develhope.Login.System.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByActivationCode(String signupActivationDTO);

    User findByPasswordResetCode(String resetPasswordCode);
}
