package it.develhope.dependencyInjection.service;

import it.develhope.dependencyInjection.component.MyComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Ho creato una classe MyService annotandola con Service
 */
@Service
public class MyService {

    /**
     * Ho creato un oggetto component di tipo MyComponent con l'annotazione Autowired
     */
    @Autowired
    MyComponent component;

    /**
     * Ho creato un metodo construttore MyService
     * @param component come parametro ha un oggetto component di tipo MyComponent
     *                  e presente anche un print con il nome del metodo
     */
    public MyService(MyComponent component){
        System.out.println("MyService constructor");
        this.component = component;
    }

    /**
     * Ho creato un metodo getName, ha un print con il nome del metodo
     * @return attraverso l'oggetto component accede al metodo getMyComponentName
     */
    public String getName(){
        System.out.println("MyService.getName");
        return component.getMyComponentName();
    }
}
