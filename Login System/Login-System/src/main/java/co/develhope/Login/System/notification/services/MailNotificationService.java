package co.develhope.Login.System.notification.services;

import co.develhope.Login.System.user.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailNotificationService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendActivationEmail(User user) {
        SimpleMailMessage sms = new SimpleMailMessage();
        sms.setTo(user.getEmail());
        sms.setFrom("almacaciulanegrea@gmail.com");
        sms.setSubject("Ti sei iscritto alla piattaforma");
        sms.setText("Il codice di attivazione e: " + user.getActivationCode());
        emailSender.send(sms);
    }

    public void sendPasswordResetMail(User user) {
        SimpleMailMessage sms = new SimpleMailMessage();
        sms.setTo(user.getEmail());
        sms.setFrom("almacaciulanegrea@gmail.com");
        sms.setSubject("Vuoi cambiare la password");
        sms.setText("Il codice di reset e: " + user.getPasswordResetCode());
        emailSender.send(sms);
    }
}
