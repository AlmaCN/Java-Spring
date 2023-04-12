package co.develhope.APICustomQueries02.repositories;

import co.develhope.APICustomQueries02.entities.Flight;
import co.develhope.APICustomQueries02.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Ho creato la FlightRepository annotandola con Repository
 */
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    /**
     * Metodo creato per cercare i voli per il loro Status
     * @param status status che puo essere ONTIME, DELAYED o CANCELLED
     * @return
     */
    List<Flight> findAllByStatus(Status status);

    /**
     * Metodo creato per cercare i voli che abbiano o uno stato specifico o un altro
     * @param p1 status che puo essere ONTIME, DELAYED o CANCELLED
     * @param p2 status che puo essere ONTIME, DELAYED o CANCELLED
     * @return
     */
    @Query(value = "SELECT * FROM flights AS f WHERE f.status = :#{#p1.name()} OR f.status = :#{#p2.name()}", nativeQuery = true)
    List<Flight> findAllFlightsWithCertainStatuses(@Param("p1") Status p1, @Param("p2") Status p2);
}
