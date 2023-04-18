/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda_IQ2023.service;

import com.Tienda_IQ2023.domain.Carrito;

public interface CarritoService {
    
    public Carrito getCarrito(Carrito carrito);
    
    public Carrito getCarritoCliente(Long idCliente);
    
    
}
