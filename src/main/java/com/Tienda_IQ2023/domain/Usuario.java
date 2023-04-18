/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda_IQ2023.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data //Crea los get y set automáticos
@Entity
@Table(name="usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private Long idCliente;
    
    private String userName;
    private String password;

    public Usuario() {
    }
    
    

    public Usuario(Long idCliente, String userName, String password) {
        this.idCliente = idCliente;
        this.userName = userName;
        this.password = password;
    }
    
    
    
    
}
