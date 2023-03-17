package com.javatechie.spring.batch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @Column(name = "cliente_id")
    private int id;
    @Column(name = "nombre")
    private String nomb;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "correo")
    private String correo;
    @Column(name = "genero")
    private String genero;
    @Column(name = "contacto")
    private String contacto;
    @Column(name = "pais")
    private String pais;
    @Column(name = "fecha_nacim")
    private String nacim;
    
}
