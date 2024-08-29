package puj.desarrolloweb.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import puj.desarrolloweb.proyecto.model.Bus;
import puj.desarrolloweb.proyecto.repository.BusRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    // CRUD básico para buses
    public List<Bus> findAll() {
        return busRepository.findAll();
    }

    public Optional<Bus> findById(Long id) {
        return busRepository.findById(id);
    }

    public Bus save(Bus bus) {
        return busRepository.save(bus);
    }

    public void deleteById(Long id) {
        busRepository.deleteById(id);
    }
}
