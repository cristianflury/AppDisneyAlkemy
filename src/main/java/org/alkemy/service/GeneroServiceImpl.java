
package org.alkemy.service;


import org.alkemy.dao.GeneroDAO;
import org.alkemy.domain.Genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Cristian
 */
@Service
@Transactional
public class GeneroServiceImpl implements GeneroService {
    
    @Autowired
    private GeneroDAO generoDao;

    @Override
    public Genero findById(Long id) {
       return   generoDao.findById(id).orElse(null);
    }

    
}
