package hotel.demo.service.impl;

import hotel.demo.domain.Reservas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hotel.demo.dao.ReservasDao;
import hotel.demo.service.RegistroService;
import hotel.demo.service.ReservasService;

@Service
public class ReservasServiceImpl implements ReservasService {

     @Autowired
    private ReservasDao reservaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Reservas> getReservas() {
        var lista = reservaDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Reservas getReserva(Reservas reserva) {
        return reservaDao.findById(reserva.getIdReserva()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Reservas reserva) {
        reservaDao.save(reserva);
    }

    @Override
    @Transactional
    public void delete(Reservas reserva) {
        reservaDao.delete(reserva);
    }
    
 
}
