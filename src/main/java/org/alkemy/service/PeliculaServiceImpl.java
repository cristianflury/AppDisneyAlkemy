package org.alkemy.service;


import org.alkemy.dao.PeliculaDAO;
import org.alkemy.domain.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Cristian
 */
@Service
@Transactional
public class PeliculaServiceImpl implements PeliculaService {
    
    @Autowired
    private PeliculaDAO peliculaDao;

    @Override
    public Iterable<Object[]> listarPeliculas() {
        
        return  peliculaDao.listarPeliculas();
    }

    @Override
    public Pelicula guardarPelicula(Pelicula pelicula) {
        return peliculaDao.save(pelicula);
    }

    @Override
    public Pelicula mostrarDetallesPelicula(Long id) {
        return peliculaDao.findById(id).orElse(null);
    }

    @Override
    public void eliminarPelicula(Long id) {
        peliculaDao.deleteById(id);
    }

    @Override
    public Iterable<Object[]> findByTitulo(String titulo) {
        
        return peliculaDao.findByTitulo(titulo);
    }

    
}
