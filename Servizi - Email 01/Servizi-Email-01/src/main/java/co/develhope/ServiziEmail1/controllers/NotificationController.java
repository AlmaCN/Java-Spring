package co.develhope.ServiziEmail1.controllers;

import co.develhope.ServiziEmail1.entities.NotificationDTO;
import co.develhope.ServiziEmail1.entities.Student;
import co.develhope.ServiziEmail1.services.EmailService;
import co.develhope.ServiziEmail1.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ho poi creato il notification controller in cui ho fatto Autowired di StudentService e di EmailService.
 * Ed ho creato il metodo sendNotification che all;interno di un try catch controlla che l'id dello studente sia
 * nella lista precedentemente creata, ed in caso di esito negativo il risultato sala una BAD REQUEST.
 * Se presente nella lista gli verra mandata una mail, se la mail viene mandata la risposta sara una 200 OK
 * se invece ci sara un errore sara un 500 INTERNAL SERVER ERROR
 */
@RestController
public class NotificationController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/notification")
    public ResponseEntity sendNotification(@RequestBody NotificationDTO payload){
        try {
            Student studentToSendNotification = studentService.getStudentById(payload.getContactId());
            System.out.println("Getting the user: " + studentToSendNotification);
            if (studentToSendNotification == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Did not find the user");
            }
            emailService.sendTo(studentToSendNotification.getEmail(), payload.getTitle(), payload.getText());
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e){
            System.err.println("Error in notification controller " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
