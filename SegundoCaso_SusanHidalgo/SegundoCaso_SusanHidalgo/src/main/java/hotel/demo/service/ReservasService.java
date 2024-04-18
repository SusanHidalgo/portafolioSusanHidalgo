package hotel.demo.service;

import hotel.demo.domain.Reservas;
import java.util.List;

public interface ReservasService {

    public List<Reservas> getReservas();

    // Se obtiene un Reserva, a partir del id de un reserva
    public Reservas getReserva(Reservas reserva);
    
    // Se inserta un nuevo reserva si el id del reserva esta vacío
    // Se actualiza un reserva si el id del reserva NO esta vacío
    public void save(Reservas reserva);
    
    // Se elimina el reserva que tiene el id pasado por parámetro
    public void delete(Reservas reserva);
    
}