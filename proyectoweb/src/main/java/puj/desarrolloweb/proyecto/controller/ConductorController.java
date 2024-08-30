package puj.desarrolloweb.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import puj.desarrolloweb.proyecto.model.Conductor;
import puj.desarrolloweb.proyecto.model.RelacionBusRutaConductor;
import puj.desarrolloweb.proyecto.service.BusService;
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
import puj.desarrolloweb.proyecto.service.ConductorService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import puj.desarrolloweb.proyecto.exceptions.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/conductores")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @Autowired
    private BusService busService;

    private static final Logger logger = LoggerFactory.getLogger(ConductorController.class);  
    // Mostrar formulario para asignar bus a conductor  
    @GetMapping("/{id}/asignar-bus")  
    public String showAssignBusForm(@PathVariable Long id, Model model) {  
        Optional<Conductor> conductorOpt = conductorService.findById(id);  
        if (conductorOpt.isPresent()) {  
            Conductor conductor = conductorOpt.get();  
            model.addAttribute("conductor", conductor);  
            model.addAttribute("buses", busService.findAll());  
            model.addAttribute("busesAsignados", conductorService.findBusesRutasHorariosByConductor(id));  
            return "asignar_bus";  
        } else {  
            return "redirect:/conductores";  
        }  
    }  

    // Asignar bus al conductor  
    @PostMapping("/{id}/asignar-bus")  
    public String assignBusToDriver(@PathVariable Long id, @RequestParam Long busId, @RequestParam String diasAsignados, RedirectAttributes redirectAttributes) {  
        try {  
            conductorService.asignarBus(id, busId, diasAsignados);  
        } catch (BusAlreadyAssignedException e) {  
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());  
            return "redirect:/conductores/" + id + "/asignar-bus";  
        }  
        return "redirect:/conductores";  
    }  
    
    // Actualizar días asignados de un bus  
    @PostMapping("/{id}/actualizar-bus")  
    public String updateBusDays(@PathVariable Long id, @RequestParam Long busId, @RequestParam String diasAsignados, RedirectAttributes redirectAttributes) {  
        try {  
            conductorService.actualizarDiasAsignados(id, busId, diasAsignados);  
        } catch (Exception e) {  
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());  
            return "redirect:/conductores/" + id + "/asignar-bus";  
        }  
        return "redirect:/conductores/" + id + "/asignar-bus";  
    }  

    // Desasignar bus del conductor  
    @GetMapping("/{id}/desasignar-bus")  
    public String unassignBusFromDriver(@PathVariable Long id, @RequestParam Long busId, RedirectAttributes redirectAttributes) {  
        try {  
            conductorService.desasignarBus(id, busId);  
        } catch (Exception e) {  
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());  
            return "redirect:/conductores/" + id + "/asignar-bus";  
        }  
        return "redirect:/conductores/" + id + "/asignar-bus";  
    }  

    @ExceptionHandler(BusAlreadyAssignedException.class)  
    public String handleBusAlreadyAssignedException(BusAlreadyAssignedException e, Model model) {  
        model.addAttribute("errorMessage", e.getMessage());  
        return "asignar_bus";  
    }  
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