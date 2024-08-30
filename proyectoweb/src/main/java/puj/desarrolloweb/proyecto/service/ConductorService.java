package puj.desarrolloweb.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import puj.desarrolloweb.proyecto.model.Bus;
import puj.desarrolloweb.proyecto.model.Conductor;
import puj.desarrolloweb.proyecto.model.RelacionBusRutaConductor;
import puj.desarrolloweb.proyecto.repository.BusRepository;
import puj.desarrolloweb.proyecto.repository.ConductorRepository;
import puj.desarrolloweb.proyecto.repository.RelacionBusRutaConductorRepository;

import puj.desarrolloweb.proyecto.exceptions.BusAlreadyAssignedException;

import java.util.List;
import java.util.Optional;

@Service
public class ConductorService {

    @Autowired
    private ConductorRepository conductorRepository;

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private RelacionBusRutaConductorRepository relacionBusRutaConductorRepository;

    // CRUD básico para conductores
    public List<Conductor> findAll() {
        return conductorRepository.findAll();
    }

    public Optional<Conductor> findById(Long id) {
        return conductorRepository.findById(id);
    }

    public Conductor save(Conductor conductor) {
        return conductorRepository.save(conductor);
    }

    public void deleteById(Long id) {
        conductorRepository.deleteById(id);
    }

    // Método para asignar un bus a un conductor con días específicos
    @Transactional
    public Conductor asignarBus(Long conductorId, Long busId, String diasAsignados) {
        Conductor conductor = conductorRepository.findById(conductorId).orElseThrow();
        Bus bus = busRepository.findById(busId).orElseThrow();

        // Verificar si el bus ya está asignado al conductor
        for (RelacionBusRutaConductor relacion : conductor.getRelacionBusRutaConductorLista()) {
            if (relacion.getBusRel().getId().equals(busId)) {
                throw new BusAlreadyAssignedException("El bus ya está asignado a este conductor.");
            }
        }

        RelacionBusRutaConductor relacion = new RelacionBusRutaConductor();
        relacion.setConductorRel(conductor);
        relacion.setBusRel(bus);
        relacion.setFecha_disponible(diasAsignados);

        relacionBusRutaConductorRepository.save(relacion);
        conductor.addBRC(relacion);
        bus.addBRC(relacion);

        return conductorRepository.save(conductor);
    }

    public void actualizarDiasAsignados(Long conductorId, Long busId, String diasAsignados) {
        RelacionBusRutaConductor relacion = relacionBusRutaConductorRepository.findByConductorRelIdAndBusRelId(conductorId, busId);
        if (relacion != null) {
            relacion.setFecha_disponible(diasAsignados);
            relacionBusRutaConductorRepository.save(relacion);
        }
    }

    // Método para desasignar bus
    public void desasignarBus(Long conductorId, Long busId) {
        RelacionBusRutaConductor relacion = relacionBusRutaConductorRepository.findByConductorRelIdAndBusRelId(conductorId, busId);
        if (relacion != null) {
            relacionBusRutaConductorRepository.delete(relacion);
        }
    }

    // Método para obtener todos los buses, rutas y horarios basados en un conductor
    public List<RelacionBusRutaConductor> findBusesRutasHorariosByConductor(Long conductorId) {
        Conductor conductor = conductorRepository.findById(conductorId).orElseThrow();
        return conductor.getRelacionBusRutaConductorLista();
    }

    // Método para actualizar las relaciones al editar un conductor
    @Transactional
    public Conductor updateConductor(Conductor conductor) {
        Optional<Conductor> existingConductorOpt = conductorRepository.findById(conductor.getId());
        if (existingConductorOpt.isPresent()) {
            Conductor existingConductor = existingConductorOpt.get();
            // Actualizar relaciones según sea necesario
            existingConductor.setNombre(conductor.getNombre());
            existingConductor.setCedula(conductor.getCedula());
            existingConductor.setDireccion(conductor.getDireccion());
            existingConductor.setTelefono(conductor.getTelefono());

            return conductorRepository.save(existingConductor);
        } else {
            throw new RuntimeException("Conductor not found");
        }
    }
}