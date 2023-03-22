
package com.Tienda_IQ2023.dao;

import com.Tienda_IQ2023.domain.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author HP PROBOOK
 */
public interface ClienteDao extends JpaRepository<Cliente, Long> {
    
    List<Cliente> findByApellidosLike(String apellidos);
}
