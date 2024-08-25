package puj.desarrolloweb.proyecto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import puj.desarrolloweb.proyecto.model.Estacion;
import puj.desarrolloweb.proyecto.repository.EstacionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EstacionService {

    @Autowired
    private EstacionRepository estacionRepository;

    // CRUD básico para estaciones
    public List<Estacion> findAll() {
        return estacionRepository.findAll();
    }

    public Optional<Estacion> findById(Long id) {
        return estacionRepository.findById(id);
    }

    public Estacion save(Estacion estacion) {
        return estacionRepository.save(estacion);
    }

    public void deleteById(Long id) {
        estacionRepository.deleteById(id);
    }
}

