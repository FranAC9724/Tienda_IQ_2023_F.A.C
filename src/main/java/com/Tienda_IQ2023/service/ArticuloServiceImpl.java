/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda_IQ2023.service;

import com.Tienda_IQ2023.dao.ArticuloDao;
import com.Tienda_IQ2023.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP PROBOOK
 */
@Service
public class ArticuloServiceImpl implements ArticuloService {
     @Autowired
    ArticuloDao articuloDao;
    
    @Override
    @Transactional(readOnly = true) //Para que en la BD esto sea de solo lectura
    public List<Articulo> getArticulos(boolean activos) {
        
        var lista = (List<Articulo>)articuloDao.findAll();
        
        if(activos){
            //Remover si no es activo
            
            lista.removeIf(e -> !e.isActivo());
        }
        
       return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Articulo articulo) {
        articuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void delete(Articulo articulo) {
        articuloDao.deleteById(articulo.getIdArticulo());
    }
}
