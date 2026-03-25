package com.veterinaria.api.service;

import java.util.List;
import com.veterinaria.api.dto.MascotaDTO;

public interface MascotaService {

    List<MascotaDTO> listar();

    MascotaDTO guardar(MascotaDTO mascota);

    MascotaDTO buscarPorId(Long id);

    MascotaDTO actualizar(Long id, MascotaDTO mascota);

    void eliminar(Long id);
}