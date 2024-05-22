package com.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;  // Asumiendo que la fecha de escritura es tipo LocalDate

@Entity(name = "libro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String autor;
    private LocalDate fechaEscritura;
    private int numeroEdicion;
    private double precio;
    private String tipo;
    private String famaEscritor;

}
