package it.develhope.firstAPI02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ho creato la classe FactorialController all'interno del package controller e l'ho comunicato a Spring attraverso
 * l'annotazione RestController
 */
@RestController
public class FactorialController {

    /**
     * Ho creato il metodo getFactorial con l'annotazione GetMapping per dare una path all'API.
     * @param n parametro in ingresso per calcolarci il fattoriale
     * @return dopo un ciclo for il risultato sara il fattoriale del numero inserito nella Get Request
     */
    @GetMapping("/get/{n}")
    public int getFactorial(@PathVariable Integer n){
        int f = 1;
        for(int i = 2; i <= n; i++){
            f = f * i;
        }
        return f;
    }
}
