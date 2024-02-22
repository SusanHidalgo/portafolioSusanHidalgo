
package com.tienda.dao;

import com.tienda.domain.categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface categoriadao extends JpaRepository <categoria,Long> {
    
}