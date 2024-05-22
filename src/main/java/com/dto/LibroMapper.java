package com.dto;

import com.entidades.Libro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LibroMapper {

    LibroMapper INSTANCE = Mappers.getMapper(LibroMapper.class);

    LibroDTO libroToLibroDTO(Libro libro);

    @Mapping(target = "fechaEscritura", source = "fechaEscritura")
    @Mapping(target = "numeroEdicion", source = "numeroEdicion")
    @Mapping(target = "precio", source = "precio")
    @Mapping(target = "tipo", source = "tipo")
    @Mapping(target = "famaEscritor", source = "famaEscritor")
    Libro libroDTOToLibro(LibroDTO libroDTO);
}
