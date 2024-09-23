package puj.desarrolloweb.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import puj.desarrolloweb.proyecto.model.Conductor;
import puj.desarrolloweb.proyecto.model.RelacionBusRutaConductor;
import puj.desarrolloweb.proyecto.service.BusService;
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
import puj.desarrolloweb.proyecto.service.ConductorService;
import puj.desarrolloweb.proyecto.exceptions.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/conductores")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @Autowired
    private BusService busService;

    private static final Logger logger = LoggerFactory.getLogger(ConductorController.class);  

    // Get all conductores
    @GetMapping
    public List<Conductor> getAllConductores() {
        return conductorService.findAll();
    }

    // Get conductor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Conductor> getConductorById(@PathVariable Long id) {
        Optional<Conductor> conductorOpt = conductorService.findById(id);
        return conductorOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create new conductor
    @PostMapping
    public Conductor createConductor(@RequestBody Conductor conductor) {
        return conductorService.save(conductor);
    }

    // Update conductor
    @PutMapping("/{id}")
    public ResponseEntity<Conductor> updateConductor(@PathVariable Long id, @RequestBody Conductor conductor) {
        conductor.setId(id);
        Conductor updatedConductor = conductorService.updateConductor(conductor);
        return ResponseEntity.ok(updatedConductor);
    }

    // Delete conductor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConductor(@PathVariable Long id) {
        conductorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Assign bus to conductor
    @PostMapping("/{id}/asignar-bus")
    public ResponseEntity<Conductor> asignarBus(@PathVariable Long id, @RequestParam Long busId, @RequestParam String diasAsignados) {
        try {
            Conductor conductor = conductorService.asignarBus(id, busId, diasAsignados);
            return ResponseEntity.ok(conductor);
        } catch (BusAlreadyAssignedException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Update bus days for conductor
    @PostMapping("/{id}/actualizar-bus")
    public ResponseEntity<Conductor> updateBusDays(@PathVariable Long id, @RequestParam Long busId, @RequestParam String diasAsignados) {
        try {
            Conductor conductor = conductorService.actualizarDiasAsignados(id, busId, diasAsignados);
            return ResponseEntity.ok(conductor);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Unassign bus from conductor
    @DeleteMapping("/{id}/desasignar-bus")
    public ResponseEntity<Conductor> unassignBus(@PathVariable Long id, @RequestParam Long busId) {
        try {
            conductorService.desasignarBus(id, busId);
            Optional<Conductor> conductorOpt = conductorService.findById(id);
            return conductorOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Get buses, routes, and schedules assigned to a conductor
    @GetMapping("/{id}/buses-rutas-horarios")
    public List<RelacionBusRutaConductor> getBusesRutasHorarios(@PathVariable Long id) {
        return conductorService.findBusesRutasHorariosByConductor(id);
    }
}