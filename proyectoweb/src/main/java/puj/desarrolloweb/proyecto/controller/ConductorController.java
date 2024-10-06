package puj.desarrolloweb.proyecto.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import puj.desarrolloweb.proyecto.dto.ConductorDTO;
import puj.desarrolloweb.proyecto.model.Conductor;
import puj.desarrolloweb.proyecto.model.RelacionBusRutaConductor;
import puj.desarrolloweb.proyecto.service.ConductorService;

@RestController
@RequestMapping("/api/conductores")
@CrossOrigin(origins = "http://localhost:4200")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    private Conductor convertToEntity(ConductorDTO dto) {
        Conductor conductor = new Conductor();
        conductor.setId(dto.getId());
        conductor.setCedula(dto.getCedula());
        conductor.setNombre(dto.getNombre());
        conductor.setTelefono(dto.getTelefono());
        conductor.setDireccion(dto.getDireccion());
        conductor.setBuses_asignados(dto.getBusesAsignados());
        return conductor;
    }

    private ConductorDTO convertToDTO(Conductor conductor) {
        ConductorDTO dto = new ConductorDTO();
        dto.setId(conductor.getId());
        dto.setCedula(conductor.getCedula());
        dto.setNombre(conductor.getNombre());
        dto.setTelefono(conductor.getTelefono());
        dto.setDireccion(conductor.getDireccion());
        dto.setBusesAsignados(conductor.getBuses_asignados());
        dto.setRelacionBusRutaConductorIds(
            conductor.getRelacionBusRutaConductorLista().stream()
                .map(RelacionBusRutaConductor::getId)
                .collect(Collectors.toList())
        );
        return dto;
    }

    @GetMapping
    public List<ConductorDTO> getAllConductores() {
        return conductorService.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConductorDTO> getConductorById(@PathVariable Long id) {
        Optional<Conductor> conductorOpt = conductorService.findById(id);
        return conductorOpt.map(conductor -> ResponseEntity.ok(convertToDTO(conductor)))
                           .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ConductorDTO createConductor(@RequestBody ConductorDTO conductorDTO) {
        Conductor conductor = convertToEntity(conductorDTO);
        return convertToDTO(conductorService.save(conductor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConductorDTO> updateConductor(@PathVariable Long id, @RequestBody ConductorDTO conductorDTO) {
        Conductor conductor = convertToEntity(conductorDTO);
        conductor.setId(id);
        Conductor updatedConductor = conductorService.updateConductor(conductor);
        return ResponseEntity.ok(convertToDTO(updatedConductor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConductor(@PathVariable Long id) {
        conductorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/asignar-bus")
    public ResponseEntity<ConductorDTO> asignarBus(@PathVariable Long id, @RequestParam Long busId, @RequestParam String diasAsignados) {
        Conductor conductor = conductorService.asignarBus(id, busId, diasAsignados);
        return ResponseEntity.ok(convertToDTO(conductor));
    }

    @GetMapping("/{id}/buses-rutas-horarios")
    public List<RelacionBusRutaConductor> getBusesRutasHorarios(@PathVariable Long id) {
        return conductorService.findBusesRutasHorariosByConductor(id);
    }
}