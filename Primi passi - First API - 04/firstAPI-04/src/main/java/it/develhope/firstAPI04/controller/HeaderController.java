package it.develhope.firstAPI04.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ho creato la classe HeaderController a cui ho dato l'annotazione RestController
 */
@RestController
public class HeaderController {

    /**
     * Ho creato il metodo getNameAndPort a cui ho dato l'annotazione getMapping.
     * @param request Ho usato un oggetto di tipo HttpServletRequest per poter prendere il nome del server e la porta
     * @return Il risultato sara una stringa che dira qual'e il nome del server e la porta
     */
    @GetMapping("/get")
    public String getNameAndPort(HttpServletRequest request){
        return "Host name: " + request.getServerName() + " Port: " + request.getServerPort();
    }
}
