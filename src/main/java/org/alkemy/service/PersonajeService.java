package org.alkemy.service;


import org.alkemy.domain.Personaje;

/**
 *
 * @author Cristian
 */
public interface PersonajeService  {
    
    public Iterable<Object[]> listarPersonajes();
    public Personaje guardarPersonaje(Personaje personaje);
    public  Personaje mostrarDetallesPersonaje(Long id);
    public void eliminarPersonaje(Long id);
    public Iterable<Object[]> findByNombre(String nombre);
    public Iterable<Object[]> findByEdad(Integer edad);
    public Iterable<Object[]> findByPeliculas(Long id);
    
    
    
}
