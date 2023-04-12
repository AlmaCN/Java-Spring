package co.exercises.swagger01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ho poi creato una classe DefaultController per chuinque accedesse a "localhost:1234", e ho modificato la porta di
 * accesso dal file application.yml.
 */
@RestController
@RequestMapping("/")
public class DefaultController {

    @GetMapping
    public String message(){
        return "Welcome to localhost";
    }
}
