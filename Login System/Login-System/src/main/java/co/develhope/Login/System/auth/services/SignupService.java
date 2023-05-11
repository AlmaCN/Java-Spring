package co.develhope.Login.System.auth.services;

import co.develhope.Login.System.auth.entities.SignupActivationDTO;
import co.develhope.Login.System.auth.entities.SignupDTO;
import co.develhope.Login.System.notification.services.MailNotificationService;
import co.develhope.Login.System.user.entities.User;
import co.develhope.Login.System.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SignupService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailNotificationService mailNotificationService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User signup(SignupDTO signupDTO) throws Exception {
        User userDB = userRepository.findByEmail(signupDTO.getEmail());
        if(userDB != null) throw new Exception("User already exists");
        User user = new User();
        user.setName(signupDTO.getName());
        user.setSurname(signupDTO.getSurname());
        user.setEmail(signupDTO.getEmail());
        user.setPassword(passwordEncoder.encode(signupDTO.getPassword()));
        user.setActive(false);
        user.setActivationCode(UUID.randomUUID().toString());

        mailNotificationService.sendActivationEmail(user);
        return userRepository.save(user);
    }

    public User activate(SignupActivationDTO signupActivationDTO) throws Exception {
        User user = userRepository.findByActivationCode(signupActivationDTO.getActivationCode());
        if(user == null) throw new Exception("User not found");
        user.setActive(true);
        user.setActivationCode(null);
        return userRepository.save(user);
    }
}
