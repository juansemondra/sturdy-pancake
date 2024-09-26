package puj.desarrolloweb.proyecto.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import puj.desarrolloweb.proyecto.dto.RutaDTO;
import puj.desarrolloweb.proyecto.model.Estacion;
import puj.desarrolloweb.proyecto.model.RelacionBusRutaConductor;
import puj.desarrolloweb.proyecto.model.Ruta;
import puj.desarrolloweb.proyecto.service.RutaService;

@RestController
@RequestMapping("/api/rutas")
public class RutaController {

    @Autowired
    private RutaService rutaService;

    private Ruta convertToEntity(RutaDTO dto) {
        Ruta ruta = new Ruta();
        ruta.setId(dto.getId());
        ruta.setNombre_ruta(dto.getNombreRuta());
        ruta.setHorario_de_inicio(dto.getHorarioDeInicio());
        ruta.setHorario_de_final(dto.getHorarioDeFinal());
        ruta.setDias_disponibles(dto.getDiasDisponibles());
        return ruta;
    }

    private RutaDTO convertToDTO(Ruta ruta) {
        RutaDTO dto = new RutaDTO();
        dto.setId(ruta.getId());
        dto.setNombreRuta(ruta.getNombre_ruta());
        dto.setHorarioDeInicio(ruta.getHorario_de_inicio());
        dto.setHorarioDeFinal(ruta.getHorario_de_final());
        dto.setDiasDisponibles(ruta.getDias_disponibles());

        dto.setEstacionIds(ruta.getEstaciones().stream()
            .map(Estacion::getId)
            .collect(Collectors.toList()));

        dto.setRelacionBusRutaConductorIds(ruta.getRelacionBusRutaConductorLista().stream()
            .map(RelacionBusRutaConductor::getId)
            .collect(Collectors.toList()));

        return dto;
    }

    @GetMapping
    public List<RutaDTO> getAllRutas() {
        return rutaService.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RutaDTO> getRutaById(@PathVariable Long id) {
        Optional<Ruta> rutaOpt = rutaService.findById(id);
        return rutaOpt.map(ruta -> ResponseEntity.ok(convertToDTO(ruta)))
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public RutaDTO createRuta(@RequestBody RutaDTO rutaDTO) {
        Ruta ruta = convertToEntity(rutaDTO);
        return convertToDTO(rutaService.save(ruta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RutaDTO> updateRuta(@PathVariable Long id, @RequestBody RutaDTO rutaDTO) {
        Ruta ruta = convertToEntity(rutaDTO);
        ruta.setId(id);
        Ruta updatedRuta = rutaService.save(ruta);
        return ResponseEntity.ok(convertToDTO(updatedRuta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRuta(@PathVariable Long id) {
        rutaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}