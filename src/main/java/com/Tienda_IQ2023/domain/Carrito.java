/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda_IQ2023.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data //Crea los get y set automáticos
@Entity
@Table(name="carrito")
public class Carrito implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarrito;
    private Long idCliente;

    public Carrito() {
    
    }

    public Carrito(Long idCliente) {
        this.idCliente = idCliente;
    }
    
    
    
    
}
