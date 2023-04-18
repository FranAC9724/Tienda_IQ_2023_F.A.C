
package com.Tienda_IQ2023.controller;

import com.Tienda_IQ2023.dao.ClienteDao;
import com.Tienda_IQ2023.dao.UsuarioDao;
import com.Tienda_IQ2023.domain.Carrito;
import com.Tienda_IQ2023.domain.CarritoDetalle;
import com.Tienda_IQ2023.domain.Cliente;
import com.Tienda_IQ2023.domain.Usuario;
import com.Tienda_IQ2023.service.ArticuloService;
import com.Tienda_IQ2023.service.CarritoDetalleService;
import com.Tienda_IQ2023.service.CarritoService;
import com.Tienda_IQ2023.service.ClienteService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Francisco Araya Carvajal
 */


@Slf4j
@Controller
public class IndexController {
  //Esto es sobre la interface pero al llevar la notacion @Service trae los metodos de quien los implemente
   @Autowired
   ClienteService clienteService;
   
   @Autowired
   ArticuloService articuloService;
   
   @Autowired
   CarritoService carritoService;
   
   @Autowired
   CarritoDetalleService carritoDetalleService;
   
   @Autowired
   UsuarioDao usuarioDao;
   
    @GetMapping("/") //Mapping de la ruta base
    public String inicio(Model model, HttpServletRequest request) {

        //Obtener Usuario logueado
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails user = null;

        if(principal instanceof UserDetails){
            user = (UserDetails) principal;
        }
             
        //Validar si usuario es cliente
        boolean esCliente = false;
        if(user!=null){
            Usuario usuario = usuarioDao.findByUsername(user.getUsername());
            
            if (usuario.getIdCliente() != null && usuario.getIdCliente() != 0){
           esCliente = true;
            Carrito carrito = carritoService.getCarritoCliente(usuario.getIdCliente());
        
            request.getSession().setAttribute("idCliente", usuario.getIdUsuario());
            request.getSession().setAttribute("idCarrito", carrito.getIdCarrito());
            request.getSession().setAttribute("esCliente", esCliente);

            List<CarritoDetalle> carritoDetalles = carritoDetalleService.getCarritoDetalles(carrito.getIdCarrito());
            model.addAttribute("cantidadArticulosCarrito",carritoDetalles.size());
            model.addAttribute("esCliente",esCliente);
            
        }
 }
        
        
        
        
        
        
        var articulo = articuloService.getArticulos(true);
        //var clientes = Arrays.asList();
        model.addAttribute("articulos", articulo);
       return "index";
    }
    
    
}

//       String mensaje = "Estamos en semana 4. Saludos";
//       model.addAttribute("MensajeSaludo", mensaje);
//       
//       Cliente cliente = new Cliente("Fran","Araya Carvajal","faraya24@qq.com","11111111");
//       Cliente cliente2 = new Cliente("Jose","Ramirez Valverde","jramval@qq.com","2222222");
//       Cliente cliente3 = new Cliente("Ana","Perez Arroyo","apear@qq.com","2222222");
//
//        //model.addAttribute("cliente", cliente);
//       
//       List<Cliente> clientes = Arrays.asList(cliente,cliente2,cliente3); //Devuelve una lista de T
//       model.addAttribute("clientes", clientes);
//       

        