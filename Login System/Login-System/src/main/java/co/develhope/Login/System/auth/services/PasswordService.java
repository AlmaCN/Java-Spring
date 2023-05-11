package co.develhope.Login.System.auth.services;

import co.develhope.Login.System.auth.entities.RequestPasswordDTO;
import co.develhope.Login.System.auth.entities.RestorePasswordDTO;
import co.develhope.Login.System.notification.services.MailNotificationService;
import co.develhope.Login.System.user.entities.User;
import co.develhope.Login.System.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PasswordService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailNotificationService mailNotificationService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User request(RequestPasswordDTO requestPasswordDTO) throws Exception {
        User userDB = userRepository.findByEmail(requestPasswordDTO.getEmail());
        if(userDB == null) throw new Exception("Cannot find user");
        userDB.setPasswordResetCode(UUID.randomUUID().toString());
        mailNotificationService.sendPasswordResetMail(userDB);
        return userRepository.save(userDB);
    }

    public User restore(RestorePasswordDTO restorePasswordDTO) throws Exception {
        User userDB = userRepository.findByPasswordResetCode(restorePasswordDTO.getResetPasswordCode());
        if(userDB == null) throw new Exception("Cannot find user");
        userDB.setPassword(passwordEncoder.encode(restorePasswordDTO.getNewPassword()));
        userDB.setPasswordResetCode(null);

        userDB.setActive(true);
        userDB.setActivationCode(null);

        return userRepository.save(userDB);
    }
}
