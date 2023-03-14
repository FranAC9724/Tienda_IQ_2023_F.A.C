/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda_IQ2023.service;

import com.Tienda_IQ2023.dao.ClienteDao;
import com.Tienda_IQ2023.dao.CreditoDao;
import com.Tienda_IQ2023.domain.Cliente;
import com.Tienda_IQ2023.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author HP PROBOOK
 */


//Implementamos la interface
//Al implementar siempre hay que poner @Service sin salto de linea

@Service
public class ClienteServiceImpl implements ClienteService {
    
    @Autowired
    ClienteDao clienteDao;
    
    @Autowired
    CreditoDao creditoDao;
    
    @Override
    @Transactional(readOnly = true) //Para que en la BD esto sea de solo lectura
    public List<Cliente> getClientes() {
        //Cast as list
       return (List<Cliente>)clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        Credito credito = cliente.getCredito();
        credito = creditoDao.save(credito);
        cliente.setCredito(credito);
        clienteDao.save(cliente);
        
        
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.deleteById(cliente.getIdCliente());
    }
    
}
