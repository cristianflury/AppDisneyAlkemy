/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alkemy.service;


import org.alkemy.domain.Pelicula;

/**
 *
 * @author Cristian
 */
public interface PeliculaService {
    
    public Iterable<Object[]> listarPeliculas();
    public Pelicula guardarPelicula(Pelicula pelicula);
    public Pelicula mostrarDetallesPelicula(Long id);
    public void eliminarPelicula(Long id);
    public Iterable<Object[]> findByTitulo(String titulo);
   
    
    
}
