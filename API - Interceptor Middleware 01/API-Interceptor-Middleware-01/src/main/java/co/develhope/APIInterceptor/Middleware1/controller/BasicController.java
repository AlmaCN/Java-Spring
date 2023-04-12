package co.develhope.APIInterceptor.Middleware1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Ho creato la classe BasicController annotandola con RestController e con RequestMappgin a /time
 */
@RestController
@RequestMapping("/time")
public class BasicController {

    /**
     * Ho creato il metodo time
     * @return ritorna la data e l'ora attuale
     */
    @GetMapping
    public LocalDateTime time(){
        return LocalDateTime.now();
    }
}
