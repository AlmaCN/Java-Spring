package co.develhope.APICustomQueries02.controllers;

import co.develhope.APICustomQueries02.entities.Flight;
import co.develhope.APICustomQueries02.enums.Status;
import co.develhope.APICustomQueries02.repositories.FlightRepository;
import co.develhope.APICustomQueries02.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * Ho creato la classe FlighController annotandola con RestController ed importando FlightREpository
 */
import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    /**
     * Nel metodo nFlights creo dei voli
     * @param n nel caso il parametro sia 0 oppure nullo, n sara in automatico 100, senno sara il numero inserito
     */
    @PostMapping
    public void nFlights(@QueryParam("n") Integer n){
        if(n == null || n == 0) {
            n = 100;
        }
        int i = 0;
        while(i < n){
            flightRepository.save(new Flight(FlightService.generateRandomString(), FlightService.generateRandomString(),
                    FlightService.generateRandomString(), Status.randomStatus()));
            i++;
        }
    }

    /**
     * Nel metodo getFlight cerco gli aerei in base all'aeroport di partenza in ordine crescente.
     * @param page la pagina che voglio vedere
     * @param size il numero di voli che voglio che siano presenti sulla pagina
     * @return il risultato sara una lista di voli
     */
    @GetMapping("/from-airport")
    public Page<Flight> getFlights(@RequestParam int page, @RequestParam int size){
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.ASC, "fromAirport"));
        Pageable pageable = PageRequest.of(page,size,sort);
        return flightRepository.findAll(pageable);
    }


    /**
     * Nel metodo flightOnTime cerco i voli che abbiano come status ONTIME
     * @return il risultato sara una lista di voli
     */
    @GetMapping("/on-time")
    public List<Flight> flightsOnTime(){
        return flightRepository.findAllByStatus(Status.ONTIME);
    }

    /**
     * Nel metodo getFlightOnStatus cerco voli che abbiamo uno stato oppure un altro
     * @param p1 status che puo essere ONTIME, DELAYED o CANCELLED
     * @param p2 status che puo essere ONTIME, DELAYED o CANCELLED
     * @return il risultato sara una lista di voli
     */
    @GetMapping("/status")
    public List<Flight> getFlightsOnStatus(@RequestParam Status p1, @RequestParam Status p2){
        return flightRepository.findAllFlightsWithCertainStatuses(p1, p2);
    }
}
