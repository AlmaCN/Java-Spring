package co.develhope.APIInterceptorMiddleware02.controllers;

import co.develhope.APIInterceptorMiddleware02.entities.Month;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ho creato il MonthController che e mappato con month.
 */
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/month")
public class MonthController {

    @GetMapping
    public Month get(HttpServletRequest request){
        return (Month) request.getAttribute("MonthInterceptor-Month");
    }
}
