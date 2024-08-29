package puj.desarrolloweb.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import puj.desarrolloweb.proyecto.model.Conductor;
import puj.desarrolloweb.proyecto.model.RelacionBusRutaConductor;
import puj.desarrolloweb.proyecto.service.ConductorService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/conductores")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    // Métodos para manejar vistas
    @GetMapping
    public String getAllConductores(Model model) {
        List<Conductor> conductores = conductorService.findAll();
        model.addAttribute("conductores", conductores);
        return "conductores";
    }

    @GetMapping("/nuevo")
    public String showCreateForm(Model model) {
        Conductor conductor = new Conductor();
        model.addAttribute("conductor", conductor);
        return "crear_conductor";
    }

    @PostMapping("/guardar")
    public String saveConductor(@ModelAttribute("conductor") Conductor conductor) {
        conductorService.save(conductor);
        return "redirect:/conductores";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Conductor> conductorOpt = conductorService.findById(id);
        if (conductorOpt.isPresent()) {
            model.addAttribute("conductor", conductorOpt.get());
            return "editar_conductor";
        } else {
            return "redirect:/conductores";
        }
    }

    @PostMapping("/actualizar/{id}")
    public String updateConductorView(@PathVariable Long id, @ModelAttribute("conductor") Conductor conductor) {
        conductor.setId(id);
        conductorService.updateConductor(conductor);
        return "redirect:/conductores";
    }

    @PostMapping("/eliminar/{id}")
    public String deleteConductorView(@PathVariable Long id) {
        conductorService.deleteById(id);
        return "redirect:/conductores";
    }

    // Métodos para manejar APIs RESTful
    @GetMapping("/api")
    @ResponseBody
    public List<Conductor> getAllConductoresApi() {
        return conductorService.findAll();
    }

    @GetMapping("/api/{id}")
    @ResponseBody
    public ResponseEntity<Conductor> getConductorByIdApi(@PathVariable Long id) {
        Optional<Conductor> conductorOpt = conductorService.findById(id);
        return conductorOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/api")
    @ResponseBody
    public Conductor createConductorApi(@RequestBody Conductor conductor) {
        return conductorService.save(conductor);
    }

    @PutMapping("/api/{id}")
    @ResponseBody
    public ResponseEntity<Conductor> updateConductorApi(@PathVariable Long id, @RequestBody Conductor conductor) {
        conductor.setId(id);
        Conductor updatedConductor = conductorService.updateConductor(conductor);
        return ResponseEntity.ok(updatedConductor);
    }

    @DeleteMapping("/api/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteConductorApi(@PathVariable Long id) {
        conductorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/api/{id}/asignar-bus")
    @ResponseBody
    public ResponseEntity<Conductor> asignarBusApi(@PathVariable Long id, @RequestParam Long busId, @RequestParam String diasAsignados) {
        Conductor conductor = conductorService.asignarBus(id, busId, diasAsignados);
        return ResponseEntity.ok(conductor);
    }

    @GetMapping("/api/{id}/buses-rutas-horarios")
    @ResponseBody
    public List<RelacionBusRutaConductor> getBusesRutasHorariosApi(@PathVariable Long id) {
        return conductorService.findBusesRutasHorariosByConductor(id);
    }
}