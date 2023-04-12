package it.develhope.firstAPI.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Ho creato la classe NameController, l'ho inserita all'interno del package controller, e le ho dato l'annotazione di
 * RestController, cosi da comunicare a Spring che e appunto un controller
 */
@RestController
public class NameController {

    /**
     * Attravero l'annotazione GetMapping ho creato una mappatura tra la richiesta Get ed il nome
     * @param name Sara il nome che inseriro
     * @return come ritorno vorro il nome
     *
     * Inizialmente avevo usato RequestParam senza aggiungere nella parentesi del GetMapping("/{name}"), e in quel caso
     * mi risultava come paramentro, cosi pero basta che aggingo /Alma e funziona lo stesso.
     *
     * Stessa cosa per PostMapping, avevo usato sempre RequestParam.
     */
    @GetMapping("/get/{name}")
    public String getName(@PathVariable String name){
        return name;
    }

    /**
     * Attraverso l'annotazione PostMapping ho creato una mappatura tra la richiesta Post ed il nome
     * @param name Il nome che voglio inserire
     * @return Ritornera il nome al contrario. Es: Alma -> amlA
     */
    @PostMapping("/post/{name}")
    public String reversedName(@PathVariable String name){
        StringBuilder sb = new StringBuilder(name);
        sb.reverse();
        String revName = sb.toString();
        return revName;
    }
}
