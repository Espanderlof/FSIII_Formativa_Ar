package com.duoc.back_libros.service;

import com.duoc.back_libros.model.Libro;
import com.duoc.back_libros.repository.LibroRepository;
import com.duoc.back_libros.patterns.LibroLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;
    private final LibroLogger logger = LibroLogger.getInstance();

    public List<Libro> getAllLibros() {
        logger.logOperation("CONSULTA", "Obteniendo todos los libros");
        return libroRepository.findAll();
    }

    public Optional<Libro> getLibroById(Long id) {
        logger.logOperation("CONSULTA", "Buscando libro con ID: " + id);
        return libroRepository.findById(id);
    }

    public Libro saveLibro(Libro libro) {
        logger.logOperation("CREACIÓN", "Creando nuevo libro: " + libro.getTitulo());
        return libroRepository.save(libro);
    }

    public void deleteLibro(Long id) {
        logger.logOperation("ELIMINACIÓN", "Eliminando libro con ID: " + id);
        libroRepository.deleteById(id);
    }

    public Libro updateLibro(Long id, Libro libroDetails) {
        Optional<Libro> libro = libroRepository.findById(id);
        if (libro.isPresent()) {
            Libro existingLibro = libro.get();
            existingLibro.setTitulo(libroDetails.getTitulo());
            existingLibro.setAutor(libroDetails.getAutor());
            existingLibro.setAnioPublicacion(libroDetails.getAnioPublicacion());
            existingLibro.setGenero(libroDetails.getGenero());
            logger.logOperation("ACTUALIZACIÓN", "Actualizando libro con ID: " + id);
            return libroRepository.save(existingLibro);
        }
        return null;
    }

    public long countLibros() {
        logger.logOperation("CONSULTA", "Contando total de libros");
        return libroRepository.count();
    }
}