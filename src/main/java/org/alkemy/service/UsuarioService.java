package org.alkemy.service;

import org.alkemy.domain.Usuario;

/**
 *
 * @author Cristian
 */
public interface UsuarioService {
     public Usuario findByUsername(String username);
     public Usuario registrar(Usuario usuario);
}
