package co.develhope.CRUD.repositories;

import co.develhope.CRUD.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Ho creato la repository di Car, CarRepository a cui ho esteso JpaRepository ed ho passato come parametri
 * Car e Integer e l'ho annotata con Repository
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
}
