package com.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibroDTO {
    private Long id;
    private String nombre;
    private String autor;
    private LocalDate fechaEscritura;
    private int numeroEdicion;
    private double precio;
    private String tipo;
    private String famaEscritor;
}
