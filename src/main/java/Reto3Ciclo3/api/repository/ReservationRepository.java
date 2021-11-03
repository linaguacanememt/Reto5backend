package Reto3Ciclo3.api.repository;

import Reto3Ciclo3.api.model.Client;
import Reto3Ciclo3.api.model.Reservation;
import Reto3Ciclo3.api.repository.Crud.ReservationCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author LGUACANEMEMT
 */
@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepo reservationCrudRepo;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepo.findAll();
    }

    public Optional<Reservation> getReservation (int id) {
        return reservationCrudRepo.findById(id);
    }

    public Reservation save(Reservation reservation){
        return reservationCrudRepo.save(reservation);
    }

    public void delete(Reservation reservation){
        reservationCrudRepo.delete(reservation);
    }

    public List<Reservation> ReservacionStatusRepositorio(String status){return reservationCrudRepo.findAllByStatus(status);
    }
    public List<Reservation> ReservacionTiempoRepositorio(Date a, Date b){
        return reservationCrudRepo.findAllByStartDateAfterAndStartDateBefore(a, b);
    }
    //ojo getClientRepository
    public List<CountClient> getClientesRepositorio(){
        List<CountClient> res = new ArrayList<>();
        List<Object[]> report = reservationCrudRepo.countTotalReservationsByClient();
        for(int i=0; i<report.size(); i++){
            res.add(new CountClient((Long)report.get(i)[1],(Client) report.get(i)[0]));
        }
        return res;
    }










}
