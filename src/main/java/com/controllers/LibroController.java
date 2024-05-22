package com.controllers;
import com.entidades.Libro;
import com.dto.LibroDTO;
import com.dto.LibroMapper;
import com.services.LibroService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/libros")  // Cambiado para ser plural, más RESTful
public class LibroController {

    private final LibroService libroService;

    @PostMapping
    public LibroDTO crearLibro(@RequestBody LibroDTO libroDTO) {
        Libro libro = LibroMapper.INSTANCE.libroDTOToLibro(libroDTO);
        Libro libroCreado = libroService.crearLibro(libro);
        return LibroMapper.INSTANCE.libroToLibroDTO(libroCreado);
    }

    @GetMapping
    public List<LibroDTO> listarLibros() {
        return libroService.listarLibros().stream()
                .map(LibroMapper.INSTANCE::libroToLibroDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public LibroDTO obtenerLibro(@PathVariable Long id) {
        return libroService.obtenerLibro(id)
                .map(LibroMapper.INSTANCE::libroToLibroDTO)
                .orElse(null);
    }

    @PutMapping("/{id}")
    public LibroDTO actualizarLibro(@PathVariable Long id, @RequestBody LibroDTO libroDTO) {
        Libro libroActualizado = libroService.actualizarLibro(id, LibroMapper.INSTANCE.libroDTOToLibro(libroDTO));
        return LibroMapper.INSTANCE.libroToLibroDTO(libroActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
    }
}

