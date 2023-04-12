package it.develhope.dependencyInjection.controller;

import it.develhope.dependencyInjection.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ho creato una classe MyController annotandola con RestController
 */
@RestController
public class MyController {

    /**
     * Ho creato un oggetto service di tipo MyService
     */
    @Autowired
    private MyService service;

    /**
     * Ho creato un metodo costruttore MyController
     * @param service ha un parametro service di tipo MyService
     *                e presente un print con il nome del metodo
     */
    public MyController(MyService service){
        System.out.println("MyController constructor");
        this.service = service;
    }

    /**
     * Ho creato un metodo getName annotato con GetMapping all'url "/getName"
     * @return attraverso l'oggetto service accede al metodo getName
     */
    @GetMapping("/getName")
    public String getName(){
        return service.getName();
    }

    /**
     * Ho creato un metodo welcomeMessage annotato con GetMapping all'url "/"
     * @return una semplice stringa con "Hello user!"
     */
    @GetMapping("/")
    public String welcomeMessage(){
        return "Hello user!";
    }
}
