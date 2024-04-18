package hotel.demo.dao;

import hotel.demo.domain.Hoteles;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelesDao extends JpaRepository <Hoteles,Long>{
    
}