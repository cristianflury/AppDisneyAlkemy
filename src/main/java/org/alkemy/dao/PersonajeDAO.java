package org.alkemy.dao;



import org.alkemy.domain.Personaje;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Cristian
 */

public interface PersonajeDAO extends CrudRepository<Personaje, Long>{
    
    @Query(value = "select imagen,nombre from personaje;" ,nativeQuery = true)
    public Iterable<Object[]> listarPersonajes();
    public Iterable<Object[]> findByNombre(String nombre);
    public Iterable<Object[]> findByEdad(Integer edad);
    public Iterable<Object[]> findByPeliculas(Long id);
}
