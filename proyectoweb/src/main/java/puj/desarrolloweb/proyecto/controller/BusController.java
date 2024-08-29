package puj.desarrolloweb.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import puj.desarrolloweb.proyecto.model.Bus;
import puj.desarrolloweb.proyecto.service.BusService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/buses")
public class BusController {

    @Autowired
    private BusService busService;

    // Obtener todos los buses
    @GetMapping
    public List<Bus> getAllBuses() {
        return busService.findAll();
    }

    // Obtener un bus por ID
    @GetMapping("/{id}")
    public ResponseEntity<Bus> getBusById(@PathVariable Long id) {
        Optional<Bus> busOpt = busService.findById(id);
        return busOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo bus
    @PostMapping
    public Bus createBus(@RequestBody Bus bus) {
        return busService.save(bus);
    }

    // Actualizar un bus existente
    @PutMapping("/{id}")
    public ResponseEntity<Bus> updateBus(@PathVariable Long id, @RequestBody Bus bus) {
        bus.setId(id);
        Bus updatedBus = busService.save(bus);
        return ResponseEntity.ok(updatedBus);
    }

    // Eliminar un bus
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBus(@PathVariable Long id) {
        busService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
