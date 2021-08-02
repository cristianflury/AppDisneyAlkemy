package org.alkemy.dao;

import org.springframework.data.repository.CrudRepository;
import org.alkemy.domain.Pelicula;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Cristian
 */
public interface PeliculaDAO extends CrudRepository<Pelicula, Long> {
    @Query(value = "select imagen,titulo,fecha_creacion from pelicula;" ,nativeQuery = true)
    public Iterable<Object[]> listarPeliculas();
    public Iterable<Object[]> findByTitulo(String titulo);   
    
}
