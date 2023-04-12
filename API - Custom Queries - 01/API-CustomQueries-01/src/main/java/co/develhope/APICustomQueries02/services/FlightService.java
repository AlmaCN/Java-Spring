package co.develhope.APICustomQueries02.services;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

/**
 * Ho creato un FlighService per avere un metodo che mi generi una stringa random di 10 caratteri. Uguale all'esercizio
 * precedente
 */
@Service
public class FlightService {

    public static String generateRandomString(){
        return RandomStringUtils.randomAlphabetic(10);
    }
}
