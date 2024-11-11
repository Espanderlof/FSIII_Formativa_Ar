package com.duoc.back_libros.service;

import com.duoc.back_libros.model.Libro;
import com.duoc.back_libros.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    public Optional<Libro> getLibroById(Long id) {
        return libroRepository.findById(id);
    }

    public Libro saveLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public void deleteLibro(Long id) {
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
            return libroRepository.save(existingLibro);
        }
        return null;
    }
    public long countLibros() {
        return libroRepository.count();
    }
}