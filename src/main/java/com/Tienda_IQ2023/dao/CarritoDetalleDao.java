/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda_IQ2023.dao;

import com.Tienda_IQ2023.domain.Articulo;
import com.Tienda_IQ2023.domain.CarritoDetalle;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author HP PROBOOK
 */
public interface CarritoDetalleDao extends CrudRepository<CarritoDetalle, Long>{
    List<CarritoDetalle> findByIdCarrito(Long idCarrito);
    CarritoDetalle findByIdCarritoAndArticulo(Long idCarrito, Articulo articulo);
    void deleteByIdCarrito(Long idCarrito);

}   

