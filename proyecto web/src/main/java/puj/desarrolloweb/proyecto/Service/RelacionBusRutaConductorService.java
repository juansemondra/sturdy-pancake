package puj.desarrolloweb.proyecto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import puj.desarrolloweb.proyecto.model.RelacionBusRutaConductor;
import puj.desarrolloweb.proyecto.repository.RelacionBusRutaConductorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RelacionBusRutaConductorService {

    @Autowired
    private RelacionBusRutaConductorRepository relacionRepository;

    // CRUD básico para la relación
    public List<RelacionBusRutaConductor> findAll() {
        return relacionRepository.findAll();
    }

    public Optional<RelacionBusRutaConductor> findById(Long id) {
        return relacionRepository.findById(id);
    }

    public RelacionBusRutaConductor save(RelacionBusRutaConductor relacion) {
        return relacionRepository.save(relacion);
    }

    public void deleteById(Long id) {
        relacionRepository.deleteById(id);
    }
}
