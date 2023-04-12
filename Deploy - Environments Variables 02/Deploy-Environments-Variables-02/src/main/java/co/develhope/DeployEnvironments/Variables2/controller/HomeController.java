package co.develhope.DeployEnvironments.Variables2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ho cambiato properties in yml ed ho creato due environment, uno per test alla porta 4000 e con un messaggio "Hello
 * from Test" ed un altro per prod alla porta 5000 con un messaggio "Hello from prod".
 * Ho creato un HomeController per ricavare la variabile welcomeMsg e ritornarla nella pagina chiamata dopo
 * l'avvio dell'applicazione
 */
@RestController
public class HomeController {

    @Autowired
    private Environment environment;

    @Value("${myCustomVarTree.welcomeMsg}")
    String welcomeMsg;

    @GetMapping
    public String getWelcomeMsg(){
        return welcomeMsg;
    }
}
