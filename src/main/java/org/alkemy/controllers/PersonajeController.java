package org.alkemy.controllers;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.alkemy.domain.Personaje;
import org.alkemy.service.PersonajeService;
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
@RequestMapping("/characters")
@RestController
public class PersonajeController {
    
    @Autowired
    private PersonajeService personajeService;
   
    
    
    @GetMapping()
    public Iterable<Object[]> obtenerListado(){
          
       return  personajeService.listarPersonajes();
       
    }
    
    @GetMapping("detalles/{id}")
    public Personaje mostrarDetallesPersonaje(@PathVariable("id") Long id){
       
        return personajeService.mostrarDetallesPersonaje(id);
    }
    
    @PostMapping()
    public Personaje crearPresonaje(@RequestParam("file")MultipartFile imagen,@ModelAttribute Personaje personaje) throws IOException{
        try {
            
            personaje.setImagen(imagen.getBytes());     
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PersonajeController.class.getName()).log(Level.SEVERE, null, ex);
        }
         return personajeService.guardarPersonaje(personaje);
    }
   
    @DeleteMapping("/{id}")
    public void eliminarPersonaje(@PathVariable("id") Long id){
        personajeService.eliminarPersonaje(id);
    }
    
    @PutMapping("/{id}")
    public Personaje actualizarPersonaje(@PathVariable("id") Long id, @RequestBody Personaje personaje ){
        personaje.setId_personaje(id);
        return personajeService.guardarPersonaje(personaje);
    }
    
    @GetMapping(params="nombre")
    public Iterable<Object[]> findByNombre(@RequestParam("nombre") String nombre){
        return personajeService.findByNombre(nombre);
    }
    
    @GetMapping(params="edad")
    public Iterable<Object[]> findByEdad(@RequestParam("edad") Integer edad){
        return personajeService.findByEdad(edad);
    }  
    
}
