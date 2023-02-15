
package com.Tienda_IQ2023.controller;

import com.Tienda_IQ2023.dao.ClienteDao;
import com.Tienda_IQ2023.domain.Cliente;
import com.Tienda_IQ2023.service.ClienteService;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @GetMapping("/") //Mapping de la ruta base
    public String inicio(Model model) {
       log.info("Proyecto con MVC");
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

        
        var clientes = clienteService.getClientes();
        //var clientes = Arrays.asList();
        model.addAttribute("clientes", clientes);
       return "index";
    }
    
    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente){
        return "modificarCliente";
    }
    
    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/"; //Esto no retorna la vista sino que al metodo controller de la vista index
    }
    
    @GetMapping("/modificarCliente/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model){
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente",cliente);
        return "modificarCliente";
    }
    
    @GetMapping("/eliminarCliente/{idCliente}")
    public String eliminarCliente(Cliente cliente){
        clienteService.delete(cliente);
        return "redirect:/";
    }
}
