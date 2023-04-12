package co.develhope.email2.emails.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * E molto simile all'esercizio precedente, l'unica differenza e che invece di SimpleMailMessage ho usato MimeMessage
 * che permette di mettere alcuni parametri html per poter inviare anche immagini.
 */
@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    public void sendTo(String email, String title, String text) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg = "<h1>Hello World!</h1>" +
                "<h2>You have a new message: </h2>" +
                "<img src='https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png' alt='Alternative text' height='200'>" +
                "<h3>" + text + "</h3>";
        helper.setText(htmlMsg, true);
        helper.setTo(email);
        helper.setSubject(title);
        helper.setFrom("devlife015@gmail.com");
        javaMailSender.send(mimeMessage);
    }
}
