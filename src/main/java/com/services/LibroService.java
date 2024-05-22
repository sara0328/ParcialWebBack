package com.services;
import com.entidades.Libro;
import com.repository.LibroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LibroService {

    private final LibroRepository libroRepository;

    public Libro crearLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    // Cambia el retorno a Optional<Libro>
    public Optional<Libro> obtenerLibro(Long id) {
        return libroRepository.findById(id);
    }

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    public Libro actualizarLibro(Long id, Libro libroDatos) {
        return libroRepository.findById(id).map(libroExistente -> {
            libroExistente.setNombre(libroDatos.getNombre());
            libroExistente.setAutor(libroDatos.getAutor());
            libroExistente.setFechaEscritura(libroDatos.getFechaEscritura());
            libroExistente.setNumeroEdicion(libroDatos.getNumeroEdicion());
            libroExistente.setPrecio(libroDatos.getPrecio());
            libroExistente.setTipo(libroDatos.getTipo());
            libroExistente.setFamaEscritor(libroDatos.getFamaEscritor());
            return libroRepository.save(libroExistente);
        }).orElse(null);
    }

    public void eliminarLibro(Long id) {
        if (libroRepository.existsById(id)) {
            libroRepository.deleteById(id);
        }
    }
}

