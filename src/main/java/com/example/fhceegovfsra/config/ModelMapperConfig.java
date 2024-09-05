package com.example.fhceegovfsra.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
/*
 * ModelMapper es una biblioteca que permite la conversión automática entre
 * objetos de diferentes tipos,
 * útil para mapear entre DTOs (Data Transfer Objects) y entidades de base de
 * datos. Su principal ventaja
 * es la capacidad de reducir el código repetitivo y errores manuales durante
 * las conversiones.
 *
 * Funciones principales:
 * - map(source, destinationClass): Convierte un objeto "source" al tipo
 * especificado "destinationClass",
 * haciendo coincidir los campos por nombre y tipo de datos.
 * - Automatiza el mapeo de propiedades con coincidencias exactas entre los
 * objetos.
 * 
 * Ventajas:
 * - Evita la necesidad de escribir código de conversión manual entre DTOs y
 * entidades.
 * - Facilita mantener una separación clara entre las capas del sistema, como la
 * capa de persistencia (entidades)
 * y la capa de negocio o API (DTOs).
 * - Reduce la cantidad de código repetitivo, especialmente útil en aplicaciones
 * con gran cantidad de modelos.
 * 
 * Personalización:
 * - Puedes configurar mapeos más complejos si los nombres o tipos no coinciden
 * exactamente,
 * mediante configuraciones personalizadas.
 * - Soporta mapeo profundo (anidado) de propiedades en objetos complejos.
 * 
 * Ejemplo:
 * // Convertir UsuarioDTO a Usuario
 * Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
 *
 * // Convertir Usuario a UsuarioDTO
 * UsuarioDTO usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
 *
 * Consideraciones:
 * - Es importante que los nombres de los campos coincidan entre los objetos
 * para que ModelMapper
 * haga el mapeo de forma automática, de lo contrario, necesitarás una
 * configuración personalizada.
 * - Para propiedades complejas o tipos no coincidentes, ModelMapper permite
 * definir reglas específicas.
 */
