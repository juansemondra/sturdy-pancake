package puj.desarrolloweb.proyecto.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.RestController;

import puj.desarrolloweb.proyecto.dto.BusDTO;
import puj.desarrolloweb.proyecto.model.Bus;
import puj.desarrolloweb.proyecto.model.RelacionBusRutaConductor;
import puj.desarrolloweb.proyecto.service.BusService;

@RestController
@RequestMapping("/api/buses")
@CrossOrigin(origins = "http://localhost:4200")
public class BusController {

    @Autowired
    private BusService busService;

    private Bus convertToEntity(BusDTO dto) {
        Bus bus = new Bus();
        bus.setId(dto.getId());
        bus.setPlaca(dto.getPlaca());
        bus.setModelo(dto.getModelo());
        return bus;
    }

    private BusDTO convertToDTO(Bus bus) {
        BusDTO dto = new BusDTO();
        dto.setId(bus.getId());
        dto.setPlaca(bus.getPlaca());
        dto.setModelo(bus.getModelo());
        dto.setRelacionBusRutaConductorIds(
            bus.getRelacionBusRutaConductorLista().stream()
                .map(RelacionBusRutaConductor::getId)
                .collect(Collectors.toList())
        );
        return dto;
    }

    @GetMapping
    @Secured({ "COORDINADOR" })
    public List<BusDTO> getAllBuses() {
        return busService.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Secured({ "COORDINADOR" })
    public ResponseEntity<BusDTO> getBusById(@PathVariable Long id) {
        Optional<Bus> busOpt = busService.findById(id);
        return busOpt.map(bus -> ResponseEntity.ok(convertToDTO(bus)))
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Secured({ "COORDINADOR" })
    public BusDTO createBus(@RequestBody BusDTO busDTO) {
        Bus bus = convertToEntity(busDTO);
        return convertToDTO(busService.save(bus));
    }

    @PutMapping("/{id}")
    @Secured({ "COORDINADOR" })
    public ResponseEntity<BusDTO> updateBus(@PathVariable Long id, @RequestBody BusDTO busDTO) {
        Bus bus = convertToEntity(busDTO);
        bus.setId(id);  
        Bus updatedBus = busService.save(bus);
        return ResponseEntity.ok(convertToDTO(updatedBus));
    }

    @DeleteMapping("/{id}")
    @Secured({ "COORDINADOR" })
    public ResponseEntity<Void> deleteBus(@PathVariable Long id) {
        busService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}