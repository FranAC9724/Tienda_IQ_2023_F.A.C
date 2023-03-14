/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.Tienda_IQ2023.controller;

import com.Tienda_IQ2023.domain.Articulo;
import com.Tienda_IQ2023.service.ArticuloService;
import com.Tienda_IQ2023.service.CategoriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author HP PROBOOK
 */
@Slf4j
@Controller
public class ArticuloController {
    @Autowired
    ArticuloService articuloService;
    
    @Autowired
    CategoriaService categoriaService;
    
    @GetMapping("/articulo/listado") //Mapping de la ruta base
    public String inicio(Model model) {

        var articulos = articuloService.getArticulos(false);
        //var articulos = Arrays.asList();
        model.addAttribute("articulos", articulos);
        return "/articulos/listado";
    }

    @GetMapping("/articulo/nuevo")
    public String nuevoArticulo(Articulo articulo, Model model) {
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("articulos",articulo);
        return "/articulo/modificar";
    }

    @PostMapping("/articulo/guardar")
    public String guardarArticulo(Articulo articulo) {
        articuloService.save(articulo);
        return "redirect:/articulo/listado"; //Esto no retorna la vista sino que al metodo controller de la vista index
    }

    @GetMapping("/articulo/modificar/{idArticulo}")
    public String modificarArticulo(Articulo articulo, Model model) {
        articulo = articuloService.getArticulo(articulo);
        model.addAttribute("articulo", articulo);
        return "/articulo/modificar";
    }

    @GetMapping("/articulo/eliminar/{idArticulo}")
    public String eliminarArticulo(Articulo articulo) {
        articuloService.delete(articulo);
        return "redirect:/articulo/eliminar";
    }

}
