package it.develhope.firstAPI03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ho creato la classe StringController e le ho assegnato l'annotazione RestController
 */
@RestController
public class StringController {

    /**
     * Ho creato il metodo getString a cui ho assegnato l'annotazione GetMapping
     * @param firstString prima Stringa che dovra essere concatenata
     * @param secondString seconda Stringa che dovra essere concatenata
     * @return se la seconda stringa e null ritorniamo solo la prima stringa, altrimenti le concateniamo
     */
    @GetMapping("/get")
    public String getStrings(@RequestParam String firstString, String secondString){
        if(secondString == null){
            return firstString;
        } else {
            return firstString + secondString;
        }
    }
}
