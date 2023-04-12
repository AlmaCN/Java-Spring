package it.develhope.firstAPI05.controller;

import it.develhope.firstAPI05.DTO.CarDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Ho creato la classe CarController a cui ho dato l'annotazione RestController
 */
@RestController
public class CarController {

    /**
     * Ho creato il metodo getCar con l'annotazione getMapping. Al suo interno ho create un nuovo oggetto di tipo
     * CarDTO
     * @return e ritornera l'oggetto car con il metodo toString().
     */
    @GetMapping("/getCar")
    public String getCar(){
        CarDTO car = new CarDTO("1", "Mercedes", 50000.0);
        return car.toString();
    }

    /**
     * Ho creato il metodo postCar con l'annotazione postMapping.
     * @param car Il parametro car di tipo CarDTO deve essere valido, ed e una BodyRequest.
     *            Ho stampato in console l'oggetto car inserito da Postman
     * @return e ho ritornato all'utente un messaggio "CREATED"
     */
    @PostMapping("/postCar")
    public HttpStatus postCar(@Valid @RequestBody CarDTO car){
        System.out.println(car.toString());
        return HttpStatus.CREATED;
    }
}
