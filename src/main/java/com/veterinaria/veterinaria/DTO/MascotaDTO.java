package com.veterinaria.api.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MascotaDTO {

    private Long id;
    private String nombre;
    private String raza;
    private int edad;
    private String propietario;
}