package puj.desarrolloweb.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import puj.desarrolloweb.proyecto.model.Conductor;

public interface ConductorRepository extends JpaRepository<Conductor, Long>{
    
}
