package Reto3Ciclo3.api.repository.Crud;

import Reto3Ciclo3.api.model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 *
 * @author LGUACANEMEMT
 */
public interface ReservationCrudRepo extends CrudRepository<Reservation, Integer> {
    public List<Reservation> findAllByStatus (String status);

    public java.util.List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    // SELECT clientid, COUNT(*) AS total FROM reservacion group by clientid order by desc;
    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationsByClient();
}
