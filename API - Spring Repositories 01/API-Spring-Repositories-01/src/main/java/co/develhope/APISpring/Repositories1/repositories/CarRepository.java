package co.develhope.APISpring.Repositories1.repositories;

import co.develhope.APISpring.Repositories1.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Ho creato la repository CarRepository annotandola con RepositoryRestResourse per poter usare HAL Explorer.
 * L'ho estesa a JpaRepository passando Car e Integer come parametri per quest'ultima.
 */
@RepositoryRestResource
public interface CarRepository extends JpaRepository<Car, Integer> {
}
