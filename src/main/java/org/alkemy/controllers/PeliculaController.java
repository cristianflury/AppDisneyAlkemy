package org.alkemy.controllers;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.alkemy.domain.Genero;
import org.alkemy.domain.Pelicula;
import org.alkemy.service.GeneroService;
import org.alkemy.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Cristian
 */
@RequestMapping("/movies")
@RestController
public class PeliculaController {
    
    @Autowired
    private PeliculaService peliculaService;
    @Autowired
    private GeneroService generoService;
    
    @GetMapping()
    public Iterable<Object[]> obtenerListado(){
        return peliculaService.listarPeliculas();
    }
    
    @GetMapping("detalles/{id}")
    public Pelicula mostrarDetallesPelicula(@PathVariable("id") Long id){
       
        return peliculaService.mostrarDetallesPelicula(id);
    }
    
    @PostMapping()
    public Pelicula crearPelicula(@RequestParam("file")MultipartFile imagen,@ModelAttribute Pelicula pelicula) throws IOException{
        try {
           
            pelicula.setImagen(imagen.getBytes());  
          
     
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PersonajeController.class.getName()).log(Level.SEVERE, null, ex);
        }
         return peliculaService.guardarPelicula(pelicula);
    }
    
    @PutMapping("/{id}")
    public Pelicula actualizarPersonaje(@PathVariable("id") Long id, @RequestBody Pelicula pelicula ){
        pelicula.setId_pelicula(id);
        return peliculaService.guardarPelicula(pelicula);
    }
    
     @DeleteMapping("/{id}")
    public void eliminarPelicula(@PathVariable("id") Long id){
        peliculaService.eliminarPelicula(id);
    }
    
    @GetMapping(params="titulo")
    public Iterable<Object[]> findByTitulo(@RequestParam("titulo") String titulo){
        return peliculaService.findByTitulo(titulo);
    }
    
    @GetMapping(params="id_genero")
    public Genero filtrarPorGenero(@RequestParam("id_genero") Long id){
        return generoService.findById(id);
    }
    

    
}
