package puj.desarrolloweb.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import puj.desarrolloweb.proyecto.model.Estacion;
import puj.desarrolloweb.proyecto.Service.EstacionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estaciones")
public class EstacionController {

    @Autowired
    private EstacionService estacionService;

    // Obtener todas las estaciones
    @GetMapping
    public List<Estacion> getAllEstaciones() {
        return estacionService.findAll();
    }

    // Obtener una estación por ID
    @GetMapping("/{id}")
    public ResponseEntity<Estacion> getEstacionById(@PathVariable Long id) {
        Optional<Estacion> estacionOpt = estacionService.findById(id);
        return estacionOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva estación
    @PostMapping
    public Estacion createEstacion(@RequestBody Estacion estacion) {
        return estacionService.save(estacion);
    }

    // Actualizar una estación existente
    @PutMapping("/{id}")
    public ResponseEntity<Estacion> updateEstacion(@PathVariable Long id, @RequestBody Estacion estacion) {
        estacion.setId(id);
        Estacion updatedEstacion = estacionService.save(estacion);
        return ResponseEntity.ok(updatedEstacion);
    }

    // Eliminar una estación
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstacion(@PathVariable Long id) {
        estacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
