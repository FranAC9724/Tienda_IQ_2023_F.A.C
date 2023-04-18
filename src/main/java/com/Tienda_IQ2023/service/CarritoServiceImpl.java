/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda_IQ2023.service;

import com.Tienda_IQ2023.dao.CarritoDao;
import com.Tienda_IQ2023.domain.Carrito;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class CarritoServiceImpl implements CarritoService {

    @Autowired 
    CarritoDao carritoDao;
    
    @Override
    public Carrito getCarrito(Carrito carrito) {
        return carritoDao.findById(carrito.getIdCarrito()).orElse(null);
    }

    @Override
    public Carrito getCarritoCliente(Long idCliente) {
        Carrito carritoCliente = carritoDao.findByIdCliente(idCliente).orElse(null);
        
        if(carritoCliente == null){
            Carrito carritoNuevo = new Carrito(idCliente);
            carritoCliente = carritoDao.save(carritoNuevo);
        }
        
        return carritoCliente;
    }
    
}
