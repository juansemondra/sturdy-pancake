package puj.desarrolloweb.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import puj.desarrolloweb.proyecto.model.Conductor;
import puj.desarrolloweb.proyecto.model.RelacionBusRutaConductor;
import puj.desarrolloweb.proyecto.Service.ConductorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/conductores")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    // Obtener todos los conductores
    @GetMapping
    public List<Conductor> getAllConductores() {
        return conductorService.findAll();
    }

    // Obtener un conductor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Conductor> getConductorById(@PathVariable Long id) {
        Optional<Conductor> conductorOpt = conductorService.findById(id);
        return conductorOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo conductor
    @PostMapping
    public Conductor createConductor(@RequestBody Conductor conductor) {
        return conductorService.save(conductor);
    }

    // Actualizar un conductor existente
    @PutMapping("/{id}")
    public ResponseEntity<Conductor> updateConductor(@PathVariable Long id, @RequestBody Conductor conductor) {
        conductor.setId(id);
        Conductor updatedConductor = conductorService.updateConductor(conductor);
        return ResponseEntity.ok(updatedConductor);
    }

    // Eliminar un conductor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConductor(@PathVariable Long id) {
        conductorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Asignar un bus a un conductor con días específicos
    @PostMapping("/{id}/asignar-bus")
    public ResponseEntity<Conductor> asignarBus(@PathVariable Long id, @RequestParam Long busId, @RequestParam String diasAsignados) {
        Conductor conductor = conductorService.asignarBus(id, busId, diasAsignados);
        return ResponseEntity.ok(conductor);
    }

    // Obtener todos los buses, rutas y horarios asignados a un conductor
    @GetMapping("/{id}/buses-rutas-horarios")
    public List<RelacionBusRutaConductor> getBusesRutasHorarios(@PathVariable Long id) {
        return conductorService.findBusesRutasHorariosByConductor(id);
    }
}
