package org.alkemy.service;


import org.alkemy.dao.PersonajeDAO;
import org.alkemy.domain.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Cristian
 */
@Service
@Transactional
public class PersonajeServiceImpl implements PersonajeService{
    
    @Autowired
    private PersonajeDAO personajeDao;
  

    @Override
    public Iterable<Object[]> listarPersonajes() {
      
        return  personajeDao.listarPersonajes();
    }

    @Override
    public Personaje guardarPersonaje(Personaje personaje) {
        return personajeDao.save(personaje);    
    }

    @Override
    public Personaje mostrarDetallesPersonaje(Long id) {
        return personajeDao.findById(id).orElse(null);
    }

    @Override
    public void eliminarPersonaje(Long id) {
        personajeDao.deleteById(id);
    }

    @Override
    public Iterable<Object[]> findByNombre(String nombre) {
        return personajeDao.findByNombre(nombre);
    }

    @Override
    public Iterable<Object[]> findByEdad(Integer edad) {
        return personajeDao.findByEdad(edad);
    }

    @Override
    public Iterable<Object[]> findByPeliculas(Long id) {
        
        return personajeDao.findByPeliculas(id);
    }

    
    
}
