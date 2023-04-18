/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda_IQ2023.service;

import com.Tienda_IQ2023.dao.CarritoDetalleDao;
import com.Tienda_IQ2023.domain.Articulo;
import com.Tienda_IQ2023.domain.CarritoDetalle;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoDetalleServiceImpl implements CarritoDetalleService{
    @Autowired
    CarritoDetalleDao carritoDetalleDao;

    @Override
    public CarritoDetalle getCarritoDetalle(CarritoDetalle carritoDetalle) {
        return carritoDetalleDao.findById(carritoDetalle.getIdCarrito()).orElse(null);
    }

    @Override
    public List<CarritoDetalle> getCarritoDetalles(Long idCarrito) {
        return carritoDetalleDao.findByIdCarrito(idCarrito);
    }

    @Override
    public void save(CarritoDetalle carritoDetalle) {
        carritoDetalleDao.save(carritoDetalle);
    }

    @Override
    public void delete(CarritoDetalle carritoDetalle) {
        carritoDetalleDao.deleteById(carritoDetalle.getIdCarrito());    
    }

    @Override
    public void deleteAll(Long idCarrito) {
        carritoDetalleDao.deleteByIdCarrito(idCarrito);  
    }
    
    @Override
    public CarritoDetalle getCarritoDetalleArticulo(Long idCarrito, Articulo articulo) {
        return carritoDetalleDao.findByIdCarritoAndArticulo(idCarrito, articulo);
    }
    
    
    
    
    
}
