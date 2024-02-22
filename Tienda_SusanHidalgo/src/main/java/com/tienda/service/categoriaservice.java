package com.tienda.service;

import com.tienda.domain.categoria;
import java.util.List;

public interface categoriaservice {
    
    // Se obtiene un listado de categorias en un List
    public List<categoria> getCategorias(boolean activos);
 
}
