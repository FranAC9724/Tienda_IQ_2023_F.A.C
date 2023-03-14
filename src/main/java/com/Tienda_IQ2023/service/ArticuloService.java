/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda_IQ2023.service;

import com.Tienda_IQ2023.domain.Articulo;
import java.util.List;

/**
 *
 * @author HP PROBOOK
 */
public interface ArticuloService {
    public List<Articulo> getArticulos(boolean activos); //Para traer articulos activas o inactivas o todas
    
    public Articulo getArticulo(Articulo articulo);
    
    public void save (Articulo articulo);
    
    public void delete(Articulo articulo);
}
