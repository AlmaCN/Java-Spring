package co.develhope.APICustomQueries01.controllers;

import co.develhope.APICustomQueries01.entities.Flight;
import co.develhope.APICustomQueries01.enums.Status;
import co.develhope.APICustomQueries01.repositories.FlightRepository;
import co.develhope.APICustomQueries01.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Ho creato la classe FlighController annotandola con RestController e importanto FlightRepository e FlightService.
 */
@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightService flightService;

    /**
     * Nel metodo create50Flights all'interno di un while ho salvato nella repository un oggetto flight con le stringhe
     * generate randomicamente e lo status settato a ONTIME
     */
    @PostMapping
    public void create50Flight(){
        int i = 0;
        while(i < 50){
            flightRepository.save(new Flight(flightService.generateRandomString(), flightService.generateRandomString(), flightService.generateRandomString(),
                    Status.ONTIME));
            i++;
        }
    }

    /**
     * Nel metodo getFlight prendo tutti i voli presenti nel database
     * @return Ritorna una Lista di voli
     */
    @GetMapping
    public List<Flight> getFlights(){
        return flightRepository.findAll();
    }
}
