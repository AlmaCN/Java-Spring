package co.develhope.ServiziLogging.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * Ho creato la classe NumberService per manipolare le variabili precedentemente create. Ho creato un oggetto di tipo
 * Environment e due variabili prese dall'application.properties attraverso il @Value.
 * Ho poi creato il metodo per ritornare la potenza dei due valori con i rispettivi logger.info.
 *
 * Ed infine ho creato un file nel resources chiamato logback-spring.xml nel quale ho inserito il codice che ha fatto
 * vedere Lorenzo nella lezione ed ho fatto in modo che creasse il file myCustomLogs nella cartella logs
 */
@Service
public class NumbersService {

    @Autowired
    private Environment environment;

    Logger logger = LoggerFactory.getLogger(NumbersService.class);

    @Value("${myCustomVar.firstInt}")
    private int firstInt;

    @Value("${myCustomVar.secondInt}")
    private int secondInt;

    public String exp(){
        try {
            logger.info("Starting");
            int powerFirst = firstInt * firstInt;
            int powerSecond = secondInt * secondInt;
            return "Power of the value " +firstInt+ "= " + powerFirst + " - Power of the value " +secondInt+"= " + powerSecond;
        } finally{
            logger.info("Ending");
        }
    }
}
