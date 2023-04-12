package co.exercises.swagger02.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ho creato un default controller che desse il benvenuto a chi accedesse a localhost:5050/
 */
@RestController
@RequestMapping("/")
public class DefaultController {

    @GetMapping
    public String defaultMessage(){
        return "Welcome!";
    }
}
