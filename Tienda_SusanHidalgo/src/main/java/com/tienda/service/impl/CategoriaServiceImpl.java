package com.tienda.service.impl;

import com.tienda.dao.categoriadao;
import com.tienda.domain.categoria;
import com.tienda.service.categoriaservice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements categoriaservice {
    
    @Autowired
    private categoriadao categoriaDao;

    @Override
    @Transactional(readOnly=true)
    public List<categoria> getCategorias(boolean activos) {
        var lista=categoriaDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
}