package co.exercises.swagger01.controllers;

/**
 * Ho creato la classe NameController annotandola con RestController per collegarla al tag presente nella classe
 * SpringFoxConfig
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class NameController {

    @GetMapping("/name")
    public String name (){
        return "Alma";
    }
}
