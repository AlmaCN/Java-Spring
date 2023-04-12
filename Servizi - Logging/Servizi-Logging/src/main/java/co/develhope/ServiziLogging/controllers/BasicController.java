package co.develhope.ServiziLogging.controllers;

import co.develhope.ServiziLogging.services.NumbersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Nell'application.properties ho fatto in modo che partisse da INFO dal livello root e da DEBUG per la cartella services.
 * Ho anche abilitato i colori ANSI
 * Ho creato anche le variabili nel app.properties con valori 2 e 8
 *
 * Ho poi creato il controller con i tre metodi ed il Logger per poter inserire info ed errori
 */
@RestController
public class BasicController {

    @Autowired
    private NumbersService numbersService;

    Logger logger = LoggerFactory.getLogger(BasicController.class);

    @GetMapping("/")
    public String getMessage(){
        logger.info("Welcome information");
        return "Welcome";
    }

    @GetMapping("/exp")
    public String exp(){
        return numbersService.exp();
    }

    @GetMapping("/get-errors")
    public void getError(){
        Error error = new Error("This is the error");
        logger.error("This is a error logging", error);
    }
}
