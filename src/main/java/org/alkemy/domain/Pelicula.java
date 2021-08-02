package org.alkemy.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name="pelicula")
public class Pelicula implements Serializable  {
     
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_pelicula;
    @Lob
    private byte[] imagen;
    private String titulo;                     
    @JsonFormat(pattern="dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date fecha_creacion;
    private Integer clasificacion;
    //@JsonIgnore
    @JsonBackReference
    @ManyToMany( mappedBy = "peliculas")
    private List<Personaje> personajes;
    
}
