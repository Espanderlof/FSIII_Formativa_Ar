package com.duoc.back_libros.controller;

import com.duoc.back_libros.model.Libro;
import com.duoc.back_libros.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/libros")
@CrossOrigin(origins = "*")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> getAllLibros() {
        return libroService.getAllLibros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable Long id) {
        return libroService.getLibroById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Libro createLibro(@RequestBody Libro libro) {
        return libroService.saveLibro(libro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable Long id, @RequestBody Libro libroDetails) {
        Libro updatedLibro = libroService.updateLibro(id, libroDetails);
        if (updatedLibro == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedLibro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLibro(@PathVariable Long id) {
        return libroService.getLibroById(id)
            .map(libro -> {
                libroService.deleteLibro(id);
                Map<String, String> response = new HashMap<>();
                response.put("mensaje", "Libro eliminado con éxito");
                return ResponseEntity.ok(response);
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/test-connection")
    public ResponseEntity<String> testConnection() {
        try {
            long count = libroService.countLibros();
            return ResponseEntity.ok("Conexión exitosa. Número de libros en la base de datos: " + count);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

}