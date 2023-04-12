package co.develhope.APIInterceptorMiddleware02.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ho creato un BasicController che dia il benvenuto a chi acceda il "sito"
 */
@RestController
public class BasicController {

    @GetMapping
    public String welcomeMsg(){
        return "Welcome!";
    }
}
