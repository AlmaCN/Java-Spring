package co.develhope.APIInterceptor.Middleware1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ho creato la classe LegacyController annotandola con RestController e con RequestMappgin a /legacy
 */
@RestController
@RequestMapping("/legacy")
public class LegacyController {

    /**
     * Ho creato il metodo message
     * @return che ritorna una stringa "This is just old code"
     */
    @GetMapping
    public String message(){
        return "This is just old code";
    }
}
