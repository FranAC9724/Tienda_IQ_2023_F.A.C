/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda_IQ2023.service;

import com.Tienda_IQ2023.domain.Articulo;
import com.Tienda_IQ2023.domain.CarritoDetalle;
import java.util.List;

public interface CarritoDetalleService {
    
    public CarritoDetalle getCarritoDetalle(CarritoDetalle carritoDetalle);
    public List<CarritoDetalle> getCarritoDetalles(Long idCarrito);
    public void save(CarritoDetalle carritoDetalle);
    public void delete(CarritoDetalle carritoDetalle);
    public void deleteAll(Long idCarrito);
    public CarritoDetalle getCarritoDetalleArticulo(Long idCarrito, Articulo articulo);
    
    
}
