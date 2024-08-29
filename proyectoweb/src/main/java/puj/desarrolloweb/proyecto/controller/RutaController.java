package puj.desarrolloweb.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import puj.desarrolloweb.proyecto.model.Ruta;
import puj.desarrolloweb.proyecto.service.RutaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rutas")
public class RutaController {

    @Autowired
    private RutaService rutaService;

    // Obtener todas las rutas
    @GetMapping
    public List<Ruta> getAllRutas() {
        return rutaService.findAll();
    }

    // Obtener una ruta por ID
    @GetMapping("/{id}")
    public ResponseEntity<Ruta> getRutaById(@PathVariable Long id) {
        Optional<Ruta> rutaOpt = rutaService.findById(id);
        return rutaOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva ruta
    @PostMapping
    public Ruta createRuta(@RequestBody Ruta ruta) {
        return rutaService.save(ruta);
    }

    // Actualizar una ruta existente
    @PutMapping("/{id}")
    public ResponseEntity<Ruta> updateRuta(@PathVariable Long id, @RequestBody Ruta ruta) {
        ruta.setId(id);
        Ruta updatedRuta = rutaService.save(ruta);
        return ResponseEntity.ok(updatedRuta);
    }

    // Eliminar una ruta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRuta(@PathVariable Long id) {
        rutaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
