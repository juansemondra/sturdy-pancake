package puj.desarrolloweb.proyecto.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RestController
@RequestMapping("/api/conductores")
@CrossOrigin(origins = "http://localhost:4200")
public class ConductorController {
    
    private static final Logger logger = LoggerFactory.getLogger(ConductorController.class);

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
    @Secured({ "COORDINADOR" })
    public List<ConductorDTO> getAllConductores() {
        return conductorService.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Secured({ "COORDINADOR" })
    public ResponseEntity<ConductorDTO> getConductorById(@PathVariable Long id) {
        Optional<Conductor> conductorOpt = conductorService.findById(id);
        return conductorOpt.map(conductor -> ResponseEntity.ok(convertToDTO(conductor)))
                           .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Secured({ "COORDINADOR" })
    public ConductorDTO createConductor(@RequestBody ConductorDTO conductorDTO) {
        Conductor conductor = convertToEntity(conductorDTO);
        return convertToDTO(conductorService.save(conductor));
    }

    @PutMapping("/{id}")
    @Secured({ "COORDINADOR" })
    public ResponseEntity<ConductorDTO> updateConductor(@PathVariable Long id, @RequestBody ConductorDTO conductorDTO) {
        try {
            Optional<Conductor> existingConductor = conductorService.findById(id);
            if (!existingConductor.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            
            Conductor conductor = convertToEntity(conductorDTO);
            conductor.setId(id);
            // Preserve existing relationships
            conductor.setRelacionBusRutaConductorLista(existingConductor.get().getRelacionBusRutaConductorLista());
            
            Conductor updatedConductor = conductorService.save(conductor);
            return ResponseEntity.ok(convertToDTO(updatedConductor));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    @Secured({ "COORDINADOR" })
    public ResponseEntity<Void> deleteConductor(@PathVariable Long id) {
        conductorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/asignar-bus")
    @Secured({ "COORDINADOR" })
    public ResponseEntity<ConductorDTO> asignarBus(@PathVariable Long id, @RequestParam Long busId, @RequestParam String diasAsignados) {
        try {
            Optional<Conductor> conductorOpt = conductorService.findById(id);
            if (!conductorOpt.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            
            Conductor conductor = conductorService.asignarBus(id, busId, diasAsignados);
            if (conductor == null) {
                conductor = conductorOpt.get(); // Use existing conductor if no changes
            }
            
            ConductorDTO dto = convertToDTO(conductor);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            logger.error("Error al asignar bus: ", e);
            // Return the current state of the conductor
            return ResponseEntity.ok(convertToDTO(conductorService.findById(id).get()));
        }
    }

    @GetMapping("/{id}/buses-rutas-horarios")
    @Secured({ "COORDINADOR" })
    public ResponseEntity<?> getBusesRutasHorarios(@PathVariable Long id) {
        try {
            Optional<Conductor> conductorOpt = conductorService.findById(id);
            if (!conductorOpt.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            
            List<RelacionBusRutaConductor> relaciones = conductorService.findBusesRutasHorariosByConductor(id);
            if (relaciones == null || relaciones.isEmpty()) {
                return ResponseEntity.ok(new ArrayList<>());
            }
            
            List<Map<String, Object>> response = relaciones.stream()
                .map(rel -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", rel.getId());
                    map.put("busId", rel.getBusRel().getId());
                    map.put("rutaId", rel.getRutaRel().getId());
                    map.put("conductorId", rel.getConductorRel().getId());
                    map.put("fechaDisponible", rel.getFecha_disponible());
                    return map;
                })
                .collect(Collectors.toList());
                
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error al obtener buses-rutas-horarios: ", e);
            return ResponseEntity.ok(new ArrayList<>()); // Return empty list instead of error
        }
    }
}