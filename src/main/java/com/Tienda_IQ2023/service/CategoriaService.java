/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda_IQ2023.service;

import com.Tienda_IQ2023.domain.Categoria;
import java.util.List;

public interface CategoriaService {
     public List<Categoria> getCategorias(boolean activos); //Para traer categorias activas o inactivas o todas
    
    public Categoria getCategoria(Categoria categoria);
    
    public void save (Categoria categoria);
    
    public void delete(Categoria categoria);
}
