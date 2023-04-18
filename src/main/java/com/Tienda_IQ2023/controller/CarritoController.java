
package com.Tienda_IQ2023.controller;

import com.Tienda_IQ2023.domain.Articulo;
import com.Tienda_IQ2023.domain.CarritoDetalle;
import com.Tienda_IQ2023.service.ArticuloService;
import com.Tienda_IQ2023.service.CarritoDetalleService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class CarritoController {
    
    @Autowired
    CarritoDetalleService carritoDetalleService;
    
    @Autowired 
    ArticuloService articuloService;
    
    @GetMapping("carrito/agregar/{idArticulo}")
    public String agregar(Articulo articulo, HttpSession session){
        Long idCarrito = (Long) session.getAttribute("idCarrito");
        
        articulo = articuloService.getArticulo(articulo);
        
        CarritoDetalle carritoDetalle = carritoDetalleService.getCarritoDetalleArticulo(idCarrito,articulo);
        
        if(carritoDetalle != null){
            carritoDetalle.setCantidad(carritoDetalle.getCantidad() + 1);
        }
        else{
            carritoDetalle = new CarritoDetalle(idCarrito,articulo,articulo.getPrecio(),1);
        }
        
        carritoDetalleService.save(carritoDetalle);
        return "redirect:/";
    }
    
    
    
    
    
    
    
    
    
    
    
}
