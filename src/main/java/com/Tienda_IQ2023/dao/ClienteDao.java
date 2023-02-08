
package com.Tienda_IQ2023.dao;

import com.Tienda_IQ2023.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author HP PROBOOK
 */
public interface ClienteDao extends CrudRepository<Cliente, Long> {
    
}
