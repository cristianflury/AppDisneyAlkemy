package org.alkemy.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Cristian
 */
@Data
@Entity
@Table(name = "personaje")
public class Personaje implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_personaje;
    @Lob
    private byte[] imagen;
    private String nombre;
    private Integer edad;
    private Integer peso;
    private String historia;
    @JsonIgnore
    @JsonManagedReference
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
		name = "personaje_pelicula",
		joinColumns = @JoinColumn(name = "personaje_id"),
        	inverseJoinColumns = @JoinColumn(name = "pelicula_id"))
    private List<Pelicula> peliculas;

}
