package co.develhope.APICustomQueries01.repositories;

import co.develhope.APICustomQueries01.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Ho creato il FlightRepository annotandolo con Repository ed estendendolo a JpaRepository
 */
@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
}
