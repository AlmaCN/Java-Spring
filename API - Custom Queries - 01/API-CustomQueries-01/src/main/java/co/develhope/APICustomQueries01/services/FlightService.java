package co.develhope.APICustomQueries01.services;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

/**
 * Ho creato un FlighService per avere un metodo che mi generi una stringa random di 10 caratteri
 */
@Service
public class FlightService {

    public String generateRandomString(){
        return RandomStringUtils.randomAlphabetic(10);
    }
}
