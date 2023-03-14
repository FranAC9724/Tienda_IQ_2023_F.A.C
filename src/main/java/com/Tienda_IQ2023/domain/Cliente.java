/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda_IQ2023.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.*; //Trae todo lo de persistence
import lombok.Data;

/**
 *
 * @author Francisco Araya Carvajal
 */
@Data //Crea los get y set automáticos
@Entity
@Table(name="cliente") //Se relaciona con la tabla de BD cliente
public class Cliente {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Se ponen en las entidades
    private Long idCliente; //Hibernate lo transforma en id_cliente
    String nombre;
    String apellidos;
    String correo;
    String telefono;
    
    
    @JoinColumn(name="id_credito",referencedColumnName = "id_credito") //Relaciones de tablas
    @ManyToOne //Muchos clientes se relacionan a un crédito
    private Credito credito;

    public Cliente() {
    }

    //Constructor sobrecargado
    public Cliente(String nombre, String apellidos, String correo, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    
}
