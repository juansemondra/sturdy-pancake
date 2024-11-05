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
import org.springframework.web.bind.annotation.RestController;

import puj.desarrolloweb.proyecto.dto.RelacionBusRutaConductorDTO;
import puj.desarrolloweb.proyecto.model.RelacionBusRutaConductor;
import puj.desarrolloweb.proyecto.service.BusService;
import puj.desarrolloweb.proyecto.service.ConductorService;
import puj.desarrolloweb.proyecto.service.RelacionBusRutaConductorService;
import puj.desarrolloweb.proyecto.service.RutaService;

@RestController
@RequestMapping("/api/relaciones")
@CrossOrigin(origins = "http://localhost:4200")
public class RelacionBusRutaConductorController {

    @Autowired
    private RelacionBusRutaConductorService relacionService;

    @Autowired
    private BusService busService;

    @Autowired
    private RutaService rutaService;

    @Autowired
    private ConductorService conductorService;

    private RelacionBusRutaConductor convertToEntity(RelacionBusRutaConductorDTO dto) {
        RelacionBusRutaConductor relacion = new RelacionBusRutaConductor();
        relacion.setId(dto.getId());
        relacion.setBusRel(busService.findById(dto.getBusId()).orElse(null));
        relacion.setRutaRel(rutaService.findById(dto.getRutaId()).orElse(null));
        relacion.setConductorRel(conductorService.findById(dto.getConductorId()).orElse(null));
        relacion.setFecha_disponible(dto.getFechaDisponible());
        return relacion;
    }

    private RelacionBusRutaConductorDTO convertToDTO(RelacionBusRutaConductor relacion) {
        RelacionBusRutaConductorDTO dto = new RelacionBusRutaConductorDTO();
        dto.setId(relacion.getId());
        dto.setBusId(relacion.getBusRel().getId());
        dto.setRutaId(relacion.getRutaRel().getId());
        dto.setConductorId(relacion.getConductorRel().getId());
        dto.setFechaDisponible(relacion.getFecha_disponible());
        return dto;
    }

    @GetMapping
    public List<RelacionBusRutaConductorDTO> getAllRelaciones() {
        return relacionService.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RelacionBusRutaConductorDTO> getRelacionById(@PathVariable Long id) {
        Optional<RelacionBusRutaConductor> relacionOpt = relacionService.findById(id);
        return relacionOpt.map(relacion -> ResponseEntity.ok(convertToDTO(relacion)))
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Secured({ "COORDINADOR" })
    public RelacionBusRutaConductorDTO createRelacion(@RequestBody RelacionBusRutaConductorDTO relacionDTO) {
        RelacionBusRutaConductor relacion = convertToEntity(relacionDTO);
        return convertToDTO(relacionService.save(relacion));
    }

    @PutMapping("/{id}")
    @Secured({ "COORDINADOR" })
    public ResponseEntity<RelacionBusRutaConductorDTO> updateRelacion(@PathVariable Long id, @RequestBody RelacionBusRutaConductorDTO relacionDTO) {
        RelacionBusRutaConductor relacion = convertToEntity(relacionDTO);
        relacion.setId(id); 
        RelacionBusRutaConductor updatedRelacion = relacionService.save(relacion);
        return ResponseEntity.ok(convertToDTO(updatedRelacion));
    }

    @DeleteMapping("/{id}")
    @Secured({ "COORDINADOR" })
    public ResponseEntity<Void> deleteRelacion(@PathVariable Long id) {
        relacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}