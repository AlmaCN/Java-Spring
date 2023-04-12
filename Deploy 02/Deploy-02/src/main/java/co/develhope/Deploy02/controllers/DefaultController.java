package co.develhope.Deploy02.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ho creato il default controller che ritornasse la somma di due numeri random. Ho cambiato application.properties in
 * yml e messo la server port di default 5000, nel caso di prod 7070 e nel caso di test 4000
 *
 * Nel pom ho cambiato la versione a 0.0.6 e ho creato il package .jar
 * L'ho provato da linea di comando e accede alla porta giusta a seconda se test o prod.
 * (Nel yml ho cambiato invece di environment: test ho scritto spring.profiles=test, senno non funzionava)
 */
@RestController
public class DefaultController {

    @GetMapping
    public int sum(){
        return 5 + 10;
    }
}
