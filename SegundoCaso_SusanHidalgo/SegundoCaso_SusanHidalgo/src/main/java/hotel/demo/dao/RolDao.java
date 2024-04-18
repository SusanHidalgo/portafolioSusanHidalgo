package hotel.demo.dao;

import hotel.demo.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolDao extends JpaRepository<Rol, Long> {

}