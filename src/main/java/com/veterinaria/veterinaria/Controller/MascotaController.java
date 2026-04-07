package com.veterinaria.veterinaria.Controller;

import com.veterinaria.veterinaria.Service.MascotaService;
import com.veterinaria.veterinaria.dto.MascotaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;


    // GET: listar todas
    @GetMapping
    public ResponseEntity<List<MascotaDTO>> listar() {
        return ResponseEntity.ok(mascotaService.listar());
    }

    // GET: buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<MascotaDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mascotaService.buscarPorId(id));
    }

    // POST: crear
    @PostMapping
    public ResponseEntity<MascotaDTO> guardar(@RequestBody MascotaDTO mascota) {
        return ResponseEntity.status(201).body(mascotaService.guardar(mascota));
    }

    // PUT: actualizar
    @PutMapping("/{id}")
    public ResponseEntity<MascotaDTO> actualizar(@PathVariable Long id,
                                                 @RequestBody MascotaDTO mascota) {
        return ResponseEntity.ok(mascotaService.actualizar(id, mascota));
    }

    // DELETE: eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        mascotaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }


}