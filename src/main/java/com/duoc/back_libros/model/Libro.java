package com.duoc.back_libros.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "LIBROS")
@Data
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    @Column(name = "anio_publicacion")
    private Integer anioPublicacion;

    @Column(nullable = false)
    private String genero;
}