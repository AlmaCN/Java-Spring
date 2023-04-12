package it.develhope.dependencyInjection.component;

import org.springframework.stereotype.Component;

/**
 * Ho creato la classe MyComponent annotandola con Component
 */
@Component
public class MyComponent {

    /**
     * Ho creato una variabile myComponentName di tipo Stringa
     */
    private final String myComponentName;

    /**
     * Ho creato il metodo costruttore in cui ho aggiunto anche un print con il nome del metodo
     */
    public MyComponent(){
        System.out.println("MyComponent constructor");
        this.myComponentName = "Alma";
    }

    /**
     * Ho creato il metodo getMyComponentName in cui ho aggiunto un print con il nome del metodo, ho creato una nuova
     * variabile myComponentImmutableName a cui ho dato il valore di myComponentName
     * @return myComponentImmutableName
     */
    public String getMyComponentName(){
        System.out.println("MyComponent.getMyComponentName");
        String myComponentImmutableName = myComponentName;
        return myComponentImmutableName;
    }
}
