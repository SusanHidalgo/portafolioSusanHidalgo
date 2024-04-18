package hotel.demo.service.impl;

import hotel.demo.dao.HotelesDao;
import hotel.demo.dao.HotelesDao;
import hotel.demo.domain.Hoteles;
import hotel.demo.service.HotelesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public abstract class HotelesServiceImpl implements HotelesService {

    @Autowired
    private HotelesDao hotelDao;

   
    @Transactional(readOnly = true)
    public List<Hoteles> getHoteles() {
        return hotelDao.findAll();
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
