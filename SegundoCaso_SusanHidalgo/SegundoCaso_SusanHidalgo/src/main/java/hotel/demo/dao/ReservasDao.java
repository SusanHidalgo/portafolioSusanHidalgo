package hotel.demo.dao;

import java.util.List;
import hotel.demo.domain.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservasDao extends JpaRepository <Reservas, Long> {
    
}