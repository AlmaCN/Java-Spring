package co.develhope.Deploy01.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ho creato un controller che ritorna una variabile devName contenente il nome Alma. Ho modificato il file properties
 * rendendolo .yml e cambiando la server port a 7070. Nel pom sono andata a cambiare la versione a 0.0.3, ho creato
 * il file .jar e sono andata ad aprirlo da linea di comando.
 */
@RestController
public class DefaultController {

    @Value("${myCustomEnvs.devName}")
    String devName;

    @GetMapping
    public String devName(){
        return devName;
    }
}
