package co.develhope.CRUD.controllers;

import co.develhope.CRUD.entities.Car;
import co.develhope.CRUD.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Ho creato il CarController annotandolo con RestController e RequestMapping che indicasse /cars
 */
@RestController
@RequestMapping("/cars")
public class CarController {

    /**
     * Ho importato un oggetto di tipo Car. (Inizialmente lo avevo annotato con Autowired, ma non partiva l'applicazione
     * e ho importato anche CarRepository.
     */

    private Car car;

    @Autowired
    private CarRepository carRepository;

    /**
     * Ho creato il metodo createNewCar
     * @param car Ho richiesto un body del oggetto car
     * @return il metodo di carRepository per salvare l'oggetto nel database
     */
    @PostMapping("/create-new-car")
    private Car createNewCar(@RequestBody Car car){
        return carRepository.save(car);
    }

    /**
     * Ho creato il metodo getAllCars
     * @return ritorna una lista di tutte le macchine presenti nel database
     */
    @GetMapping("/get-all-cars")
    private List<Car> getAllCars(){
        return carRepository.findAll();
    }

    /**
     * Ho creato il metodo getCarById
     * @param id e richiesto un parametro id di tipo int
     * Se non esiste nel database verra ritornato un oggetto Car vuoto
     * @return se esiste verra ritornato l'oggetto con l'id richiesto
     */
    @GetMapping("/get-car-by-id")
    private Optional<Car> getCarById(@RequestParam int id){
        if(!carRepository.existsById(id)){
            return Optional.of(new Car());
        }
        return carRepository.findById(id);
    }

    /**
     * Ho creato il metodo updateTypeOfCar
     * @param id e richiesto un parametro id di tipo int
     * @param newType e richiesto un parametro newTtpe di tipo String
     * Se non esiste l'id nel database verra ritornato un oggetto Car vuoto
     * @return se esiste verra settato un altro Type della car chiamata e verra salvata nel database
     */
    @PutMapping("/update-car")
    private Car updateTypeOfCar(@RequestParam int id, @RequestParam String newType){
        if(!carRepository.existsById(id)){
            return new Car();
        }
        Optional<Car> optionalCar = carRepository.findById(id);
        Car updatedCar = optionalCar.get();
        updatedCar.setType(newType);
        return carRepository.save(updatedCar);
    }

    /**
     * Ho creato il metodo deleteByCarId
     * @param id e richiesto un parametro id di tipo int
     * se l'id richiesto non esiste il programma rispondera con un status CONFLICT
     * se invece esiste, eliminera la macchina
     */
    @DeleteMapping("/delete-car-by-id")
    private void deleteCarById(@RequestParam int id){
        Optional<Car> optionalCar = carRepository.findById(id);
        if(optionalCar.isEmpty()){
            ResponseEntity.status(HttpStatus.CONFLICT);
        }
        carRepository.deleteById(id);
    }

    /**
     * Ho creato il metodo deleteAllCars che elimina tutte le macchina dal database
     */
    @DeleteMapping("/delete-all-cars")
    public void deleteAllCars(){
        carRepository.deleteAll();
    }

}
