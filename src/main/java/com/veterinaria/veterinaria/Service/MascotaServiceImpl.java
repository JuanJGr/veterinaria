package com.veterinaria.veterinaria.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.veterinaria.veterinaria.dto.MascotaDTO;
import com.veterinaria.veterinaria.Model.Mascota;
import com.veterinaria.veterinaria.Repository.MascotaRepository;

@Service
public class MascotaServiceImpl implements MascotaService {

    @Autowired
    private MascotaRepository repository;

    private MascotaDTO convertirADTO(Mascota mascota) {
        return new MascotaDTO(
                mascota.getId(),
                mascota.getNombre(),
                mascota.getRaza(),
                mascota.getEdad(),
                mascota.getPropietario()
        );
    }

    private Mascota convertirAEntidad(MascotaDTO dto) {
        return new Mascota(
                dto.getId(),
                dto.getNombre(),
                dto.getRaza(),
                dto.getEdad(),
                dto.getPropietario()
        );
    }

    @Override
    public List<MascotaDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    @Override
    public MascotaDTO guardar(MascotaDTO mascotaDTO) {
        Mascota mascota = convertirAEntidad(mascotaDTO);
        return convertirADTO(repository.save(mascota));
    }

    @Override
    public MascotaDTO buscarPorId(Long id) {
        Mascota mascota = repository.findById(id).orElse(null);
        return mascota != null ? convertirADTO(mascota) : null;
    }

    @Override
    public MascotaDTO actualizar(Long id, MascotaDTO mascotaDTO) {
        Mascota mascota = repository.findById(id).orElse(null);

        if (mascota != null) {
            mascota.setNombre(mascotaDTO.getNombre());
            mascota.setRaza(mascotaDTO.getRaza());
            mascota.setEdad(mascotaDTO.getEdad());
            mascota.setPropietario(mascotaDTO.getPropietario());
            return convertirADTO(repository.save(mascota));
        }
        return null;
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}