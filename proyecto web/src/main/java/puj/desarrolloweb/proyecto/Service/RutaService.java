package puj.desarrolloweb.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import puj.desarrolloweb.proyecto.model.Ruta;
import puj.desarrolloweb.proyecto.repository.RutaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RutaService {

    @Autowired
    private RutaRepository rutaRepository;

    // CRUD básico para rutas
    public List<Ruta> findAll() {
        return rutaRepository.findAll();
    }

    public Optional<Ruta> findById(Long id) {
        return rutaRepository.findById(id);
    }

    public Ruta save(Ruta ruta) {
        return rutaRepository.save(ruta);
    }

    public void deleteById(Long id) {
        rutaRepository.deleteById(id);
    }
}
