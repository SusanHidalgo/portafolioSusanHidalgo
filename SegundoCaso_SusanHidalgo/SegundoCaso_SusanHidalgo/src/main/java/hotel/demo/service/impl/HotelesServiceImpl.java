package hotel.demo.service.impl;

import hotel.demo.domain.Hoteles;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hotel.demo.dao.HotelesDao;
import hotel.demo.service.HotelesService;


@Service
public abstract class HotelesServiceImpl implements HotelesService {
    @Autowired
    private HotelesDao hotelDao;
    
    
    @Transactional(readOnly=true)
    public List<Hoteles> getHoteles() {
        var lista=hotelDao.findAll();
        return lista;
    }


    @Transactional(readOnly = true)
    public Hoteles getHotel(Hoteles hotel) {
        return hotelDao.findById(hotel.getId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Hoteles hotel) {
        hotelDao.save(hotel);
    }

    @Override
    @Transactional
    public void delete(Hoteles hotel) {
        hotelDao.delete(hotel);
    }
}
