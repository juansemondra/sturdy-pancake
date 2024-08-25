package puj.desarrolloweb.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import puj.desarrolloweb.proyecto.model.RelacionBusRutaConductor;
import puj.desarrolloweb.proyecto.Service.RelacionBusRutaConductorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/relaciones")
public class RelacionBusRutaConductorController {

    @Autowired
    private RelacionBusRutaConductorService relacionService;

    // Obtener todas las relaciones
    @GetMapping
    public List<RelacionBusRutaConductor> getAllRelaciones() {
        return relacionService.findAll();
    }

    // Obtener una relación por ID
    @GetMapping("/{id}")
    public ResponseEntity<RelacionBusRutaConductor> getRelacionById(@PathVariable Long id) {
        Optional<RelacionBusRutaConductor> relacionOpt = relacionService.findById(id);
        return relacionOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva relación
    @PostMapping
    public RelacionBusRutaConductor createRelacion(@RequestBody RelacionBusRutaConductor relacion) {
        return relacionService.save(relacion);
    }

    // Actualizar una relación existente
    @PutMapping("/{id}")
    public ResponseEntity<RelacionBusRutaConductor> updateRelacion(@PathVariable Long id, @RequestBody RelacionBusRutaConductor relacion) {
        relacion.setId(id);
        RelacionBusRutaConductor updatedRelacion = relacionService.save(relacion);
        return ResponseEntity.ok(updatedRelacion);
    }

    // Eliminar una relación
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRelacion(@PathVariable Long id) {
        relacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
