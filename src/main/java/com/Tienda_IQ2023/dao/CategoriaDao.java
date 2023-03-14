/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda_IQ2023.dao;

import com.Tienda_IQ2023.domain.Categoria;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author HP PROBOOK
 */
public interface CategoriaDao extends CrudRepository<Categoria, Long> {
    
}
