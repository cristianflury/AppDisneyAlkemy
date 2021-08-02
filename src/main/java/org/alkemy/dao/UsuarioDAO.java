/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alkemy.dao;

import org.alkemy.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Cristian
 */
public interface UsuarioDAO extends JpaRepository<Usuario, Long>{
    public Usuario findByUsername(String username);
    
}
