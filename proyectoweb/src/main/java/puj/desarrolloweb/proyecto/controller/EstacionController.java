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

import puj.desarrolloweb.proyecto.dto.EstacionDTO;
import puj.desarrolloweb.proyecto.model.Estacion;
import puj.desarrolloweb.proyecto.model.Ruta;
import puj.desarrolloweb.proyecto.service.EstacionService;

@RestController
@RequestMapping("/api/estaciones")
@CrossOrigin(origins = "http://localhost:4200")
public class EstacionController {

    @Autowired
    private EstacionService estacionService;

    private Estacion convertToEntity(EstacionDTO dto) {
        Estacion estacion = new Estacion();
        estacion.setId(dto.getId());
        estacion.setNombre(dto.getNombre());
        estacion.setZona(dto.getZona());
        return estacion;
    }

    private EstacionDTO convertToDTO(Estacion estacion) {
        EstacionDTO dto = new EstacionDTO();
        dto.setId(estacion.getId());
        dto.setNombre(estacion.getNombre());
        dto.setZona(estacion.getZona());
        dto.setRutaIds(
            estacion.getRutas().stream()
                .map(Ruta::getId)
                .collect(Collectors.toList())
        );
        return dto;
    }

    @GetMapping
    public List<EstacionDTO> getAllEstaciones() {
        return estacionService.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstacionDTO> getEstacionById(@PathVariable Long id) {
        Optional<Estacion> estacionOpt = estacionService.findById(id);
        return estacionOpt.map(estacion -> ResponseEntity.ok(convertToDTO(estacion)))
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public EstacionDTO createEstacion(@RequestBody EstacionDTO estacionDTO) {
        Estacion estacion = convertToEntity(estacionDTO);
        return convertToDTO(estacionService.save(estacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstacionDTO> updateEstacion(@PathVariable Long id, @RequestBody EstacionDTO estacionDTO) {
        Estacion estacion = convertToEntity(estacionDTO);
        estacion.setId(id);
        Estacion updatedEstacion = estacionService.save(estacion);
        return ResponseEntity.ok(convertToDTO(updatedEstacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstacion(@PathVariable Long id) {
        estacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}