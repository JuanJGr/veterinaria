package com.veterinaria.veterinaria.Service;

import java.util.List;
import com.veterinaria.veterinaria.dto.MascotaDTO;

public interface MascotaService {

    List<MascotaDTO> listar();

    MascotaDTO guardar(MascotaDTO mascota);

    MascotaDTO buscarPorId(Long id);

    MascotaDTO actualizar(Long id, MascotaDTO mascota);

    void eliminar(Long id);
}