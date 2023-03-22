/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.Tienda_IQ2023.controller;

import com.Tienda_IQ2023.domain.Cliente;
import com.Tienda_IQ2023.service.ClienteService;
import java.util.List;
import java.util.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HP PROBOOK
 */
@Slf4j
@Controller
public class ClienteController {
    @Autowired
    ClienteService clienteService;
    
    private static final Logger LOGGER = Logger.getLogger(ClienteController.class.getName());
    
    @GetMapping("/cliente/listado") //Mapping de la ruta base
    public String inicio(Model model) {
        var clientes = clienteService.getClientes();
        //var clientes = Arrays.asList();
        model.addAttribute("clientes", clientes);
        return "/cliente/listado";
    }

    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(Cliente cliente) {
        return "/cliente/modificar";
    }

    @PostMapping("/cliente/guardar")
    public String guardarCliente(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado"; //Esto no retorna la vista sino que al metodo controller de la vista index
    }

    @GetMapping("/cliente/modificar/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modificar";
    }

    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminarCliente(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }
    
    @GetMapping("/cliente/buscarClientes")
    public String buscarClientes() {
        return "/cliente/buscarClientes";
    }
    
    @GetMapping("/cliente/buscarApellidos")
    public String buscarPorApellidos(String apellidos, Model model) {
        log.info("Apellidos: " + apellidos);
        model.addAttribute("apellidos", apellidos);
        var clientes = clienteService.getClienteByApellidos(apellidos);
        model.addAttribute("clientes", clientes);
        log.info("Cliente: " + clientes);
        return "/cliente/buscarClientes";
    }
    
}
