package com.factoriaf5.firstspring.firstspring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name= "contacto")

public class Contacto {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "correo", nullable = false)
    private String correo;
    @Column(name = "telefono", nullable = false)
    private String telefono;
    @Column(name = "mensaje", nullable = false)
    private String mensaje;

public Contacto(){

}

public Contacto (Long id, String nombre, String correo, String telefono, String mensaje){
    this.id= id;
    this.nombre =nombre;
    this.telefono= telefono;
    this.correo= correo;
    this.mensaje= mensaje;
}




}
